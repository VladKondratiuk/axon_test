package com.example.axon_test.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.domain.entity.User
import com.example.domain.usecase.UserUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ProfileViewModel(
    context: Context,
    private val userUseCase: UserUseCase
) : BaseViewModel(context.applicationContext as Application) {

    init {
        getCachedUser()
    }

    val onCachedUserUpdate = MutableLiveData<User>()

    private fun getCachedUser() {
        userUseCase
            .getCachedUser()
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .map { onCachedUserUpdate.value = it }
            .subscribe({ onSuccess }, onError)
            .addToBag()
    }
}