package com.example.domain.repository

import com.example.domain.entity.User
import io.reactivex.Observable

interface UserRepository {

    fun getRandomUsers(): Observable<List<User>>
}