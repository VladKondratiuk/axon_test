package com.example.remote.api

import com.example.remote.model.UsersRemote
import io.reactivex.Observable
import retrofit2.http.GET

interface UserService {

    @GET("https://randomuser.me/api/?results=20")
    fun getRandomUsers(): Observable<UsersRemote>
}