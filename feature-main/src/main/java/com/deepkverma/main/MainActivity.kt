package com.deepkverma.main

import android.app.Application
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.deepkverma.core.AppGraph
import com.deepkverma.core.data.local.DataBaseService
import com.deepkverma.core.utils.MemoryLooger
import com.deepkverma.main.di.component.ActivityComponent
import com.deepkverma.main.di.component.DaggerActivityComponent
import com.deepkverma.main.di.module.ActivityModule
import com.deepkverma.main.ui.theme.MyDaggerApplicationTheme


import javax.inject.Inject
import com.deepkverma.main.viewmodel.*

class MainActivity : ComponentActivity() {



    lateinit var activityComponent: ActivityComponent


    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory


    fun getDependecies(appGraph: AppGraph) {

        activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this)).applicationComponent(appGraph.applicationComponent)
            .build()

        activityComponent.inject(this) // This should match `fun inject(activity: MainActivity)`
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val appGraph by lazy { application as AppGraph }
        val db by lazy { appGraph.appDatabaseService }
        val logger by lazy { appGraph.appMemoryLogger }
        enableEdgeToEdge()

        // ✅ Must call this BEFORE using any @Inject vars
        getDependecies(appGraph)

        // ✅ Now it's safe to use injected dependencies
        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

        setContent {

            MyDaggerApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android  ${db.dbName}",
                        modifier = Modifier.padding(innerPadding),
                        mainViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, mainViewModel: MainViewModel) {
    val message by mainViewModel.message.collectAsState()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = message)
        Button(onClick = { mainViewModel.updateMessage() }) {
            Text("Update Message")
        }

    }
}
