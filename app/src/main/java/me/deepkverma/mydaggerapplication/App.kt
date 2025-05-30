package me.deepkverma.mydaggerapplication

import android.app.Application
import android.os.Handler
import android.widget.Toast
import com.deepkverma.core.data.local.DataBaseService
import me.deepkverma.mydaggerapplication.di.component.ApplicationComponent
import me.deepkverma.mydaggerapplication.di.module.ApplicationModule
import com.deepkverma.core.utils.MemoryLooger
import kotlinx.coroutines.delay
import me.deepkverma.mydaggerapplication.di.component.DaggerApplicationComponent
import timber.log.Timber
import javax.inject.Inject


  class App : Application() {
    lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var databaseService: DataBaseService

    @Inject
    lateinit var memoryLogger: MemoryLooger


    override fun onCreate() {
        super.onCreate()
        getDependencies();
        Timber.plant(Timber.DebugTree())


        Toast.makeText(this, databaseService.dbName, Toast.LENGTH_LONG).show()
        memoryLogger.logD(databaseService.dbName)
    }

    fun getDependencies() {

        applicationComponent = DaggerApplicationComponent.builder().applicationModule(
            ApplicationModule(this)
        ).build()

        applicationComponent.inject(this)
    }
}