package com.example.axon_test.injection.component

import com.example.axon_test.injection.module.ActivitiesModule
import com.example.axon_test.injection.module.AppModule
import com.example.axon_test.injection.DaggerApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivitiesModule::class,
        AppModule::class
    ]
)
internal interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DaggerApplication>()
}
