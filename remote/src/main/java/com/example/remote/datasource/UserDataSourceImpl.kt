package com.example.remote.datasource

import com.example.remote.api.UserService
import com.example.remote.model.UsersRemote
import io.reactivex.Observable

class UserDataSourceImpl(private val userApi: UserService) : UserDataSource {

    override fun getRandomUsers(): Observable<UsersRemote> {
        return userApi.getRandomUsers()
    }
}