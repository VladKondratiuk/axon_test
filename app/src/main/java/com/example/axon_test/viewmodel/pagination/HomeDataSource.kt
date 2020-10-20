package com.example.axon_test.viewmodel.pagination

import android.content.Context
import androidx.paging.PageKeyedDataSource
import com.example.axon_test.adapter.item.BaseItem
import com.example.axon_test.viewmodel.mapper.UsersMapper
import com.example.domain.usecase.UserUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class HomeDataSource(
    private val context: Context,
    private val userUseCase: UserUseCase
) : PageKeyedDataSource<String, BaseItem>() {

    private val mapper = UsersMapper()
    private var nextPageKey: String? = null

    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<String, BaseItem>
    ) {
        userUseCase
            .getRandomUsers()
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                callback.onResult(mapper.toItems(it), null, nextPageKey)
            }
            .subscribe()
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, BaseItem>) {
        userUseCase
            .getRandomUsers()
            .subscribeOn(Schedulers.computation())
            .map {
                Timber.e(it.toString())
                mapper.toItems(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                callback.onResult(it, nextPageKey)
            }
            .subscribe()
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, BaseItem>) {
    }
}