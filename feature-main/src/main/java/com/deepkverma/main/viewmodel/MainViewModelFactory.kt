package com.deepkverma.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.deepkverma.core.data.local.DataBaseService
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val databaseService: DataBaseService
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(databaseService) as T
    }
}