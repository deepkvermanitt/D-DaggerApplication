package me.deepkverma.mydaggerapplication.di.component

import dagger.Component
import me.deepkverma.mydaggerapplication.App
import me.deepkverma.mydaggerapplication.di.module.ApplicationModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(app: App)
}