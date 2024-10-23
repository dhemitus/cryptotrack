package com.dhemitus.cryptotrack

import android.app.Application
import com.dhemitus.cryptotrack.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CryptoTrackApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CryptoTrackApp)
            androidLogger()
            modules(appModule)
        }
    }
}