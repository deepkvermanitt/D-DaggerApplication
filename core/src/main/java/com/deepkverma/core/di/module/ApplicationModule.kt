package com.deepkverma.core.di.module

import com.deepkverma.core.di.qualifier.qualifiers
import com.deepkverma.core.utils.AppMemoryLogger
import com.deepkverma.core.utils.MemoryLogger
import com.deepkverma.core.utils.TestMemoryLogger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule() {


    @Provides
    @qualifiers.DataBaseName
    fun provideDatabaseName(): String = "dummy_db"

    @Provides
    @qualifiers.AppMemoryLogger
    fun provideAppMemoryLogger(): AppMemoryLogger {
        return MemoryLogger()
    }

    @Provides
    @qualifiers.TestMemoryLogger
    fun provideTestMemoryLogger(): AppMemoryLogger {
        return TestMemoryLogger()
    }


}