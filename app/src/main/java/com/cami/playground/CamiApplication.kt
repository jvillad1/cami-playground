package com.cami.playground

import android.app.Application
import timber.log.Timber

class CamiApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        // Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
