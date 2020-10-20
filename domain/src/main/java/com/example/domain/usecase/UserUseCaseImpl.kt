package com.example.domain.usecase

import com.example.domain.entity.User
import com.example.domain.repository.UserRepository
import io.reactivex.Observable

class UserUseCaseImpl(private val userRepository: UserRepository) : UserUseCase {

    override fun getRandomUsers(): Observable<List<User>> {
        return userRepository.getRandomUsers()
    }
}