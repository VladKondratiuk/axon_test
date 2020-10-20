package com.example.axon_test.injection.module.main

import android.content.Context
import com.example.axon_test.injection.scope.MainScope
import com.example.axon_test.viewmodel.pagination.HomeDataSourceFactory
import com.example.domain.repository.UserRepository
import com.example.domain.usecase.UserUseCase
import com.example.domain.usecase.UserUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
internal class MainProviderModule {

    @MainScope
    @Provides
    internal fun provideHomeDataSourceFactory(
        context: Context, userUseCase: UserUseCase
    ): HomeDataSourceFactory {
        return HomeDataSourceFactory(context, userUseCase)
    }

    @MainScope
    @Provides
    internal fun provideUserUseCase(
        userRepository: UserRepository
    ): UserUseCase {
        return UserUseCaseImpl(userRepository)
    }
}
