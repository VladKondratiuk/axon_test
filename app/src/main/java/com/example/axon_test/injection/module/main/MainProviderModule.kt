package com.example.axon_test.injection.module.main

import android.content.Context
import com.example.axon_test.injection.scope.MainScope
import com.example.axon_test.viewmodel.pagination.HomeDataSourceFactory
import dagger.Module
import dagger.Provides

@Module
internal class MainProviderModule {

    @MainScope
    @Provides
    internal fun provideHomeDataSourceFactory(
        context: Context
    ): HomeDataSourceFactory {
        return HomeDataSourceFactory(context)
    }
}
