package com.example.domain.usecase

import com.example.domain.entity.User
import io.reactivex.Observable

interface UserUseCase {

    fun getRandomUsers(): Observable<List<User>>
}