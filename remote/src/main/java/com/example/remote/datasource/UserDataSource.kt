package com.example.remote.datasource

import com.example.remote.model.UsersRemote
import io.reactivex.Observable

interface UserDataSource {

    fun getRandomUsers(): Observable<UsersRemote>
}