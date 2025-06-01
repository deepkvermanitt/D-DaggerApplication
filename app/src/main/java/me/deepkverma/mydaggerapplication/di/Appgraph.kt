package me.deepkverma.mydaggerapplication.di

import com.deepkverma.core.data.local.DataBaseService
import com.deepkverma.core.utils.MemoryLogger
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface AppGraph {
    fun dataBaseService(): DataBaseService
    fun memoryLogger(): MemoryLogger
}