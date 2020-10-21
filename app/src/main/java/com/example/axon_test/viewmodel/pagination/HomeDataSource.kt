package com.example.axon_test.viewmodel.pagination

import android.content.Context
import com.example.axon_test.adapter.item.BaseItem
import com.example.axon_test.viewmodel.mapper.UsersMapper
import com.example.domain.usecase.UserUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeDataSource(
    private val context: Context,
    private val userUseCase: UserUseCase
) : BaseDataSource() {

    private val mapper = UsersMapper()

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<BaseItem>) {
        userUseCase
            .getRandomUsers()
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { callback.onResult(mapper.toItems(it), 0) }
            .subscribe(onSuccess, onError)
            .addToBag()
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<BaseItem>) {
        userUseCase
            .getRandomUsers()
            .subscribeOn(Schedulers.computation())
            .map { mapper.toItems(it) }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { callback.onResult(it) }
            .subscribe(onSuccess, onError)
            .addToBag()
    }
}