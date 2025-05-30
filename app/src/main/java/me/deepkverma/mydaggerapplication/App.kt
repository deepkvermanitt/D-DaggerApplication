package me.deepkverma.mydaggerapplication

import android.app.Application
import android.health.connect.datatypes.units.Length
import android.widget.Toast
import me.deepkverma.mydaggerapplication.data.local.DataBaseService
import me.deepkverma.mydaggerapplication.di.component.ApplicationComponent
import me.deepkverma.mydaggerapplication.di.component.DaggerApplicationComponent
import me.deepkverma.mydaggerapplication.di.module.ApplicationModule
import me.deepkverma.mydaggerapplication.utils.MemoryLooger
import timber.log.Timber
import javax.inject.Inject
import me.deepkverma.mydaggerapplication.App



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