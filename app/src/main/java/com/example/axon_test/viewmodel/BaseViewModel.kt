package com.example.axon_test.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.example.axon_test.utils.PAGE_SIZE
import com.example.axon_test.utils.SingleLiveData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : AndroidViewModel {

    val tag = "BaseViewModel"
    private val disposables = CompositeDisposable()
    open val loading = MutableLiveData<Boolean>()
    open val error = SingleLiveData<String>()

    val context: Context

    constructor(application: Application) : super(application) {
        this.context = application
    }

    private fun addDisposable(disposable: Disposable) = disposables.add(disposable)

    fun Disposable.addToBag() = addDisposable(this)

    override fun onCleared() {
        disposables.dispose()
    }

    protected fun defaultConfig(): PagedList.Config {
        return PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(PAGE_SIZE)
            .setPageSize(PAGE_SIZE)
            .build()
    }
}
