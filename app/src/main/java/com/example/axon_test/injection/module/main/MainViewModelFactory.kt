package com.example.axon_test.injection.module.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.axon_test.viewmodel.HomeViewModel
import com.example.axon_test.viewmodel.ProfileViewModel
import com.example.axon_test.viewmodel.pagination.HomeDataSourceFactory
import com.example.domain.usecase.UserUseCase
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    val context: Context,
    private val homeDataSourceFactory: HomeDataSourceFactory,
    private val userUseCase: UserUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {

            modelClass.isAssignableFrom(HomeViewModel::class.java) ->
                HomeViewModel(context, homeDataSourceFactory, userUseCase) as T

            modelClass.isAssignableFrom(ProfileViewModel::class.java) ->
                ProfileViewModel(context, userUseCase) as T

            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}
