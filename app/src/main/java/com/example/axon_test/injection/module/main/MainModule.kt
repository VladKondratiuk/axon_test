package com.example.axon_test.injection.module.main

import androidx.lifecycle.ViewModelProvider
import com.example.axon_test.injection.scope.MainScope
import com.example.axon_test.view.HomeFragment
import com.example.axon_test.view.ProfileFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [MainProviderModule::class])
abstract class MainModule {

    @Binds
    @MainScope
    internal abstract fun viewModelFactory(factory: MainViewModelFactory): ViewModelProvider.Factory

    @ContributesAndroidInjector
    internal abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    internal abstract fun contributeProfileFragment(): ProfileFragment
}
