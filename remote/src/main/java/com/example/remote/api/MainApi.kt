package com.example.remote.api

import com.example.remote.model.UsersRemote
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.OkHttpClient
import java.lang.reflect.Modifier
import java.util.concurrent.TimeUnit

class MainApi(
    baseUrl: String
) : BaseApi(), UserService {

    private val userService: UserService

    init {
        val httpClient = OkHttpClient.Builder()
            .connectTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)

        val client = httpClient.build()

        val gson = GsonBuilder()
            .excludeFieldsWithModifiers(Modifier.TRANSIENT, Modifier.STATIC)
            .create()

        val retrofit = buildRetrofit(baseUrl, client, gson)
        userService = retrofit.create(UserService::class.java)
    }

    override fun getRandomUsers(): Observable<UsersRemote> =
        userService.getRandomUsers()
}
