package com.deepkverma.main.di.module.subcomponent

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface UserComponentEntryPoint {
    fun userComponentFactory(): UserComponent.Factory
}