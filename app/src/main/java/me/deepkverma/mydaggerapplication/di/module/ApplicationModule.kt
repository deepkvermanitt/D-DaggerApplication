package me.deepkverma.mydaggerapplication.di.module

import dagger.Module
import me.deepkverma.mydaggerapplication.App

@Module
class ApplicationModule(private val application: App) {
}