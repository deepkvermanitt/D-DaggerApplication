package me.deepkverma.mydaggerapplication.main

import android.os.Bundle
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
import com.deepkverma.core.data.local.DataBaseService
import me.deepkverma.mydaggerapplication.App
 import me.deepkverma.mydaggerapplication.di.component.ActivityComponent
import me.deepkverma.mydaggerapplication.di.component.DaggerActivityComponent
import me.deepkverma.mydaggerapplication.di.module.ActivityModule
import me.deepkverma.mydaggerapplication.ui.theme.MyDaggerApplicationTheme
import com.deepkverma.core.utils.MemoryLooger

import javax.inject.Inject

class MainActivity : ComponentActivity() {

    lateinit var activityComponent: ActivityComponent
    @Inject
    lateinit var databaseService: DataBaseService
    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var memoryLogger: MemoryLooger
     fun getDependecies() {
         activityComponent =   DaggerActivityComponent.builder()
            .applicationComponent((application as App).applicationComponent)
        .activityModule(ActivityModule(this))
        .build()

         activityComponent.inject(this) // This should match `fun inject(activity: MainActivity)`
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            getDependecies()
            mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

            MyDaggerApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android  ${databaseService.dbName}",
                        modifier = Modifier.padding(innerPadding),
                        mainViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier,mainViewModel: MainViewModel) {
    val message by mainViewModel.message.collectAsState()

    Column(modifier = modifier.fillMaxSize(),
            horizontalAlignment=Alignment.CenterHorizontally) {
        Text(text = message)
        Button(onClick = { mainViewModel.updateMessage() }) {
            Text("Update Message")
        }

    }
}
