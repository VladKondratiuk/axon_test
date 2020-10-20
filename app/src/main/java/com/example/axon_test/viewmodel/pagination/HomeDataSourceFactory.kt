package com.example.axon_test.viewmodel.pagination

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.axon_test.adapter.item.BaseItem
import com.example.domain.usecase.UserUseCase

class HomeDataSourceFactory(private val context: Context, private val userUseCase: UserUseCase) :
    DataSource.Factory<String, BaseItem>() {

    private val onDataSourceUpdate = MutableLiveData<HomeDataSource>()

    override fun create(): DataSource<String, BaseItem> {
        val dataSource = HomeDataSource(context, userUseCase)
        onDataSourceUpdate.postValue(dataSource)
        return dataSource
    }
}