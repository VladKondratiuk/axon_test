package com.example.axon_test.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.axon_test.utils.SingleLiveData
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

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
}
