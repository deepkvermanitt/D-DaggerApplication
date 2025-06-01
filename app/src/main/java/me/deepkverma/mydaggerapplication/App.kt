package me.deepkverma.mydaggerapplication

import android.app.Application
import com.deepkverma.core.di.qualifier.qualifiers
import com.deepkverma.core.utils.AppMemoryLogger
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject
import com.deepkverma.core.utils.MemoryLogger

@HiltAndroidApp
class App : Application() {
    @Inject
    @qualifiers.AppMemoryLogger
    lateinit var logger: AppMemoryLogger

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        logger.logD("App Launched")
    }
}