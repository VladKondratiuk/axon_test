package com.example.axon_test.viewmodel.pagination

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.example.axon_test.adapter.item.UserItem
import com.example.axon_test.utils.SingleLiveData
import com.example.axon_test.utils.composeExecutionThreads
import com.example.axon_test.viewmodel.mapper.UsersMapper
import com.example.domain.entity.User
import io.reactivex.rxjava3.core.Observable
import timber.log.Timber

class HomeDataSource(
    private val context: Context
) : PageKeyedDataSource<String, UserItem>() {

    private val mapper = UsersMapper()

    private var nextPageKey: String? = null

    val isInitial = MutableLiveData<Boolean>()
    val onError = SingleLiveData<String>()

    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<String, UserItem>
    ) {
        returnUsers()
//            .composeExecutionThreads()
            .doOnNext {
                callback.onResult(mapper.toItems(it), null, nextPageKey)
            }
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, UserItem>) {

    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, UserItem>) {
    }

    fun refresh() = invalidate()

    private fun returnUsers(): Observable<List<User>> {
        return Observable.just(listOf(User("1"), User("2"), User("3")))
    }
}