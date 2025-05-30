package me.deepkverma.mydaggerapplication.main

import androidx.lifecycle.ViewModel
import com.deepkverma.core.data.local.DataBaseService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class MainViewModel @Inject constructor(val dataBaseService: DataBaseService) : ViewModel() {
    private val _message = MutableStateFlow("Initial State")
    val message: StateFlow<String> = _message
    fun updateMessage() {
        _message.value = dataBaseService.dbName
    }


}