package com.example.domain.repository

import com.example.domain.entity.User
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface UserRepository {

    fun getRandomUsers(): Observable<List<User>>

    fun cacheUser(user: User): Completable

    fun getCachedUser(): Single<User>
}