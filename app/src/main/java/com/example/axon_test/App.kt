package com.example.axon_test

import com.example.axon_test.injection.DaggerApplication
import com.jakewharton.threetenabp.AndroidThreeTen
import timber.log.Timber

class App : DaggerApplication() {

    companion object {
        @JvmStatic
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        AndroidThreeTen.init(this)
    }
}
