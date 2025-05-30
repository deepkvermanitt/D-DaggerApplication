package com.deepkverma.main

import com.deepkverma.core.data.local.DataBaseService
import com.deepkverma.main.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.kotlin.mock


import org.junit.Assert.assertEquals
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever


@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    private lateinit var dataBaseService: DataBaseService
    private lateinit var viewModel: MainViewModel

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        // Mock the DB service
        dataBaseService = mock()
        whenever(dataBaseService.dbName).thenReturn("Welcome to Dagger!", "Dagger Updated")

        viewModel = MainViewModel(dataBaseService)

    }

    @Test
    fun `initial state should be default`() = runTest {
        val initialMessage = viewModel.message.first()
        assertEquals("Initial State", initialMessage)
    }

    @Test
    fun `update message should change`() = runTest {
        viewModel.updateMessage()
        val updatedMessage = viewModel.message.value
        assertEquals("TestDB", updatedMessage)
    }

    @Test
    fun `update message should update after update mesage call`() = runTest {
        val messages = mutableListOf<String>()
        val job = launch {
            viewModel.message.take(2).collect {
                messages.add(it)
            }
        }
        viewModel.updateMessage()
        advanceUntilIdle() // Needed if updateMessage uses delay or coroutine

        assertEquals(listOf("Welcome to Dagger!"), messages)

        job.cancel()
    }
    @Test
    fun `verify dbName was accessed`() = runTest {
        viewModel.updateMessage()
        verify(dataBaseService).dbName
    }
}