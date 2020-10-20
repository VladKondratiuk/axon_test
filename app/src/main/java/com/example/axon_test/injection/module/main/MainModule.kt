package com.example.axon_test.injection.module.main

import androidx.lifecycle.ViewModelProvider
import com.example.axon_test.injection.scope.MainScope
import dagger.Binds
import dagger.Module

@Module(includes = [MainProviderModule::class])
abstract class MainModule {

    @Binds
    @MainScope
    internal abstract fun viewModelFactory(factory: MainViewModelFactory): ViewModelProvider.Factory

//    @ContributesAndroidInjector
//    internal abstract fun contributeProfileFragment(): ProfileFragment
}
