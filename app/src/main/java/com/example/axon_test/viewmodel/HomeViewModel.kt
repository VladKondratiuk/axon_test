package com.example.axon_test.viewmodel

import android.app.Application
import android.content.Context
import androidx.paging.LivePagedListBuilder
import com.example.axon_test.utils.SingleLiveData
import com.example.axon_test.viewmodel.pagination.HomeDataSourceFactory
import com.example.domain.entity.User
import com.example.domain.usecase.UserUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel(
    context: Context,
    private val homeDataSourceFactory: HomeDataSourceFactory,
    private val userUseCase: UserUseCase
) : BaseViewModel(context.applicationContext as Application) {

    val items = LivePagedListBuilder(homeDataSourceFactory, defaultConfig()).build()
    val onUserCached = SingleLiveData<Boolean>()

    fun refresh() {
        homeDataSourceFactory.onDataSourceUpdate.value?.invalidate()
        loading.value = false
    }

    fun cacheUser(user: User) {
        userUseCase
            .cacheUser(user)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnComplete { onUserCached.value = true }
            .subscribe({ onSuccess }, onError)
            .addToBag()
    }
}