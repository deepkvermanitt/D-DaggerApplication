package me.deepkverma.mydaggerapplication.di.component

import com.deepkverma.core.data.local.DataBaseService
import me.deepkverma.mydaggerapplication.di.module.ApplicationModule
import com.deepkverma.core.utils.MemoryLooger
import dagger.Component
import me.deepkverma.mydaggerapplication.App
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(app: App)

    fun getDatabaseService(): DataBaseService
    fun getMemoryLogger(): MemoryLooger
}