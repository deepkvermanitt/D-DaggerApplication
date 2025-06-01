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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

import com.deepkverma.main.ui.theme.MyDaggerApplicationTheme


import javax.inject.Inject
import com.deepkverma.main.viewmodel.*
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors
import com.deepkverma.main.di.module.subcomponent.UserComponentEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val entryPoint = EntryPointAccessors.fromApplication(application
            ,
            UserComponentEntryPoint::class.java
        )
        val userComponent = entryPoint.userComponentFactory().create()
        userComponent.inject(this)

        enableEdgeToEdge()

        setContent {

            MyDaggerApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android  ",
                        modifier = Modifier.padding(innerPadding),

                        )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val viewModel: MainViewModel = hiltViewModel()
    val message by viewModel.message.collectAsState()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = message)
        Button(onClick = {viewModel.updateMessage() }) {
            Text("Update Message")
        }

    }
}
