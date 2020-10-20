package com.example.axon_test.injection.module

import com.example.axon_test.view.MainActivity
import com.example.axon_test.injection.module.main.MainModule
import com.example.axon_test.injection.scope.MainScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivitiesModule {

    @MainScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun contributeMainActivity(): MainActivity

}
