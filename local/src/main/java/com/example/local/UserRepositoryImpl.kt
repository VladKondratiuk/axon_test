package com.example.local

import com.example.domain.entity.User
import com.example.domain.repository.UserRepository
import com.example.remote.datasource.UserDataSource
import io.reactivex.Observable

class UserRepositoryImpl(private val userDataSource: UserDataSource) : UserRepository {

    override fun getRandomUsers(): Observable<List<User>> {
        return userDataSource.getRandomUsers()
            .map {
                listOf()
            }
    }
}