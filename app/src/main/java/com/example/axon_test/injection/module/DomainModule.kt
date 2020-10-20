package com.example.axon_test.injection.module

import com.example.domain.repository.UserRepository
import com.example.domain.usecase.UserUseCase
import com.example.domain.usecase.UserUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class DomainModule {

    @Provides
    @Singleton
    internal fun provideUserUseCase(
        userRepository: UserRepository,
    ): UserUseCase {
        return UserUseCaseImpl(userRepository)
    }
}
