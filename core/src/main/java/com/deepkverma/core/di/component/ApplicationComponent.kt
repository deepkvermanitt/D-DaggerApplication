package com.deepkverma.core.di.component

import android.app.Application
import com.deepkverma.core.data.local.DataBaseService
import com.deepkverma.core.di.module.ApplicationModule
import com.deepkverma.core.utils.MemoryLooger
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(app: Application)

    fun getDatabaseService(): DataBaseService
    fun getMemoryLogger(): MemoryLooger
}