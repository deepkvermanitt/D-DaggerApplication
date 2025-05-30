package me.deepkverma.mydaggerapplication

import android.app.Application
import android.os.Handler
import android.widget.Toast
import com.deepkverma.core.AppGraph
import com.deepkverma.core.data.local.DataBaseService
import com.deepkverma.core.di.component.ApplicationComponent
import com.deepkverma.core.di.component.DaggerApplicationComponent
import com.deepkverma.core.di.module.ApplicationModule
import com.deepkverma.core.utils.MemoryLooger
import kotlinx.coroutines.delay
 import timber.log.Timber
import javax.inject.Inject


class App : Application(), AppGraph {
    override val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override val appDatabaseService: DataBaseService
        get() = applicationComponent.getDatabaseService()

    override val appMemoryLogger: MemoryLooger
        get() = applicationComponent.getMemoryLogger()

    @Inject
    lateinit var databaseService: DataBaseService

    @Inject
    lateinit var memoryLogger: MemoryLooger


    override fun onCreate() {
        super.onCreate()
        getDependencies();
        Timber.plant(Timber.DebugTree())


     //   Toast.makeText(this, databaseService.dbName, Toast.LENGTH_LONG).show()
       //\ memoryLogger.logD(databaseService.dbName)
    }

    fun getDependencies() {
        applicationComponent.inject(this)
    }
}