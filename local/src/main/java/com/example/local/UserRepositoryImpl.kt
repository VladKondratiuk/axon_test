package com.example.local

import com.example.domain.entity.User
import com.example.domain.repository.UserRepository
import com.example.local.mapper.UserMapper
import com.example.remote.datasource.UserDataSource
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class UserRepositoryImpl(
    private val userDataSource: UserDataSource,
    private val userMapper: UserMapper
) : UserRepository {

    private var user: User? = null

    override fun getRandomUsers(): Observable<List<User>> {
        return userDataSource.getRandomUsers()
            .map { userMapper.toLocalItems(it) }
    }

    override fun cacheUser(user: User): Completable {
        this.user = user
        return Completable.complete()
    }

    override fun getCachedUser(): Single<User> {
        return Single.just(user)
    }
}