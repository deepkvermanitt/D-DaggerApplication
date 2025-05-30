package me.deepkverma.mydaggerapplication.main

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import me.deepkverma.mydaggerapplication.data.local.DataBaseService
import javax.inject.Inject

class MainViewModel @Inject constructor(val dataBaseService: DataBaseService) : ViewModel() {
    private val _message = MutableStateFlow("Initial State")
    val message: StateFlow<String> = _message
    fun updateMessage() {
        _message.value = dataBaseService.dbName
    }


}