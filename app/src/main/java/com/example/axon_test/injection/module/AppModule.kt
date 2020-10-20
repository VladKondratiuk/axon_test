package com.example.axon_test.injection.module

import android.content.Context
import com.example.axon_test.injection.DaggerApplication
import com.example.axon_test.navigation.Navigator
import com.example.axon_test.navigation.NavigatorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class AppModule {

    @Provides
    @Singleton
    internal fun providesContext(application: DaggerApplication): Context =
        application.applicationContext

    @Provides
    @Singleton
    internal fun provideNavigator(): Navigator = NavigatorImpl()
}
