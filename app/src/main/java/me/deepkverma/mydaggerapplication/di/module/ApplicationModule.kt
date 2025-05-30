package me.deepkverma.mydaggerapplication.di.module

import android.app.Application
import android.content.Context
import com.deepkverma.core.data.local.DataBaseService
import com.deepkverma.core.di.qualifier.qualifiers
import com.deepkverma.core.utils.MemoryLooger
import dagger.Module
import dagger.Provides
import me.deepkverma.mydaggerapplication.App
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: App) {


    @qualifiers.ApplicationContext
    @Provides
    fun provideContext(): Context {
        return application
    }
    @Singleton
    @Provides
    fun provideDatabaseService(): DataBaseService {
        return DataBaseService(application, provideDatabaseName())
    }
    @Provides
    @qualifiers.DataBaseName
    fun provideDatabaseName(): String = "dummy_db"
//
//    @Provides
//    @qualifiers.DataBaseVersion
//    fun provideDatabaseVersion(): Int = 1

    fun provideMemoryLogger () : MemoryLooger {
        return MemoryLooger()
    }



}