package com.example.local

import com.example.domain.entity.User
import com.example.domain.repository.UserRepository
import io.reactivex.Observable

class UserRepositoryImpl : UserRepository {

    override fun getRandomUsers(): Observable<List<User>> {
        return Observable.just(listOf())
    }
}