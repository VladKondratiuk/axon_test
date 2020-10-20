package com.example.axon_test.viewmodel

import android.app.Application
import android.content.Context
import androidx.paging.LivePagedListBuilder
import com.example.axon_test.viewmodel.pagination.HomeDataSourceFactory

class HomeViewModel(
    context: Context,
    homeDataSourceFactory: HomeDataSourceFactory
) : BaseViewModel(context.applicationContext as Application) {

    val items = LivePagedListBuilder(homeDataSourceFactory, defaultConfig()).build()
}