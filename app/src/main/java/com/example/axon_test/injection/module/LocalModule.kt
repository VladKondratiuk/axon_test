package com.example.axon_test.injection.module

import com.example.domain.repository.UserRepository
import com.example.local.BuildConfig
import com.example.local.UserRepositoryImpl
import com.example.local.mapper.UserMapper
import com.example.remote.api.MainApi
import com.example.remote.api.UserService
import com.example.remote.datasource.UserDataSource
import com.example.remote.datasource.UserDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class LocalModule {

    private val baseUrl = if (BuildConfig.DEBUG) {
        "https://randomuser.me/api/"
    } else {
        "https://randomuser.me/api/"
    }

    @Provides
    @Singleton
    internal fun provideApiAuth(): MainApi = MainApi(baseUrl)

    @Provides
    @Singleton
    internal fun provideUserRepository(
        userDataSource: UserDataSource,
        userMapper: UserMapper
    ): UserRepository {
        return UserRepositoryImpl(userDataSource, userMapper)
    }

    @Provides
    @Singleton
    internal fun provideUserDataSource(
        userService: UserService
    ): UserDataSource {
        return UserDataSourceImpl(userService)
    }

    @Provides
    @Singleton
    internal fun provideUserService(api: MainApi): UserService = api


    @Provides
    @Singleton
    internal fun provideUserMapper() = UserMapper()
}