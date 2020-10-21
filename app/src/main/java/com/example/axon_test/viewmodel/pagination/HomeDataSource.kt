package com.example.axon_test.viewmodel.pagination

import android.content.Context
import androidx.paging.PageKeyedDataSource
import com.example.axon_test.adapter.item.BaseItem
import com.example.axon_test.viewmodel.mapper.UsersMapper
import com.example.domain.entity.User
import com.example.domain.usecase.UserUseCase
import io.reactivex.observers.DisposableObserver
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
            .subscribe(object : DisposableObserver<List<User>>() {

                override fun onStart() {}

                override fun onNext(users: List<User>) {
                    callback.onResult(mapper.toItems(users), null, nextPageKey)
                }

                override fun onError(e: Throwable) {
                    Timber.e(e)
                }

                override fun onComplete() {}
            })
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, BaseItem>) {
        userUseCase
            .getRandomUsers()
            .subscribe(object : DisposableObserver<List<User>>() {

                override fun onStart() {}

                override fun onNext(users: List<User>) {
                    callback.onResult(mapper.toItems(users), null)
                }

                override fun onError(e: Throwable) {
                    Timber.e(e)
                }

                override fun onComplete() {}
            })
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, BaseItem>) {
    }
}