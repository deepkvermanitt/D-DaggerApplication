package com.deepkverma.main.viewmodel

import androidx.lifecycle.ViewModel
import com.deepkverma.core.data.local.DataBaseService
import com.deepkverma.core.di.qualifier.qualifiers
import com.deepkverma.core.utils.AppMemoryLogger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dbService: DataBaseService,
    @qualifiers.AppMemoryLogger private val logger: AppMemoryLogger
) : ViewModel() {
    private val _message = MutableStateFlow("Initial State")
    val message: StateFlow<String> = _message
    fun updateMessage() {
        logger.logD("Message Updated")
        _message.value = "Updated at ${System.currentTimeMillis()}"
    }


}