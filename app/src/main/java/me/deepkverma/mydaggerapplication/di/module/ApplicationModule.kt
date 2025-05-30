package me.deepkverma.mydaggerapplication.di.module

import android.content.Context
import com.deepkverma.core.di.qualifier.qualifiers
import dagger.Module
import dagger.Provides
import me.deepkverma.mydaggerapplication.App
import com.deepkverma.core.utils.MemoryLooger

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