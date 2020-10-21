package com.example.domain.usecase

import com.example.domain.entity.User
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface UserUseCase {

    fun getRandomUsers(): Observable<List<User>>

    fun cacheUser(user: User): Completable

    fun getCachedUser(): Single<User>
}