package me.deepkverma.mydaggerapplication.di.component

import com.deepkverma.core.data.local.DataBaseService
import dagger.Component
import me.deepkverma.mydaggerapplication.App
import me.deepkverma.mydaggerapplication.di.module.ApplicationModule
import me.deepkverma.mydaggerapplication.utils.MemoryLooger
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(app: App)

    fun getDatabaseService(): DataBaseService
    fun getMemoryLogger(): MemoryLooger
}