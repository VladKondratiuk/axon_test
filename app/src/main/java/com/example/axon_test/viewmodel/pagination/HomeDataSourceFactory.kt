package com.example.axon_test.viewmodel.pagination

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.axon_test.adapter.item.UserItem

//private val usersUseCase: UsersUseCase
class HomeDataSourceFactory(private val context: Context) :
    DataSource.Factory<String, UserItem>() {

    private val onDataSourceUpdate = MutableLiveData<HomeDataSource>()

    override fun create(): DataSource<String, UserItem> {
        val dataSource = HomeDataSource(context)
        onDataSourceUpdate.postValue(dataSource)
        return dataSource
    }
}