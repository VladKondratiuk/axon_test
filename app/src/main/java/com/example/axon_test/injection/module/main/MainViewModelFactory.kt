package com.example.axon_test.injection.module.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    val context: Context
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {

//            modelClass.isAssignableFrom(ScrumBoardSettingsViewModel::class.java) ->
//                ScrumBoardSettingsViewModel(context) as T

            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}
