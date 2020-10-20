package com.example.axon_test.injection.module

import com.example.domain.repository.UserRepository
import com.example.local.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class LocalModule {

    @Provides
    @Singleton
    internal fun provideUserRepository(): UserRepository {
        return UserRepositoryImpl()
    }
}