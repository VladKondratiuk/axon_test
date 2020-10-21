package com.example.axon_test.viewmodel.pagination

import androidx.lifecycle.MutableLiveData
import androidx.paging.PositionalDataSource
import com.example.axon_test.adapter.item.BaseItem
import com.example.axon_test.utils.SingleLiveData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import timber.log.Timber

abstract class BaseDataSource : PositionalDataSource<BaseItem>() {

    private val disposables = CompositeDisposable()
    open val loading = MutableLiveData<Boolean>()
    open val error = SingleLiveData<String>()

    fun Disposable.addToBag() = addDisposable(this)

    open val onSuccess = Consumer<Any> {
        loading.value = true
    }

    open val onError = Consumer<Throwable> {
        Timber.e(it)
        loading.value = false
    }

    private fun addDisposable(disposable: Disposable) = disposables.add(disposable)
}