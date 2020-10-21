package com.example.domain.usecase

import com.example.domain.entity.User
import com.example.domain.repository.UserRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class UserUseCaseImpl(private val userRepository: UserRepository) : UserUseCase {

    override fun getRandomUsers(): Observable<List<User>> {
        return userRepository.getRandomUsers()
    }

    override fun cacheUser(user: User): Completable {
        return userRepository.cacheUser(user)
    }

    override fun getCachedUser(): Single<User> {
        return userRepository.getCachedUser()
    }
}