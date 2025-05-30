package me.deepkverma.mydaggerapplication.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import me.deepkverma.mydaggerapplication.App
import me.deepkverma.mydaggerapplication.di.qualifiers
import me.deepkverma.mydaggerapplication.utils.MemoryLooger
import timber.log.Timber

@Module
class ApplicationModule(private val application: App) {


    @qualifiers.ApplicationContext
    @Provides
    fun provideContext(): Context {
        return application
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