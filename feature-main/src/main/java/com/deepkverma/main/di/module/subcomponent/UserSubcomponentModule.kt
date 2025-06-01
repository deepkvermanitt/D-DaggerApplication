package com.deepkverma.main.di.module.subcomponent

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(subcomponents = [UserComponent::class])
@InstallIn(SingletonComponent::class)
object UserSubcomponentModule