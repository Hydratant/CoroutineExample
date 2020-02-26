package com.tami.base.coroutine

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CoApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Koin Init
        startKoin {
            androidLogger()
            androidContext(this@CoApplication)
            modules(appModule)
        }
    }
}