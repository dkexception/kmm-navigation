package io.github.dkexception.kmm.navigation

import android.app.Application
import io.github.dkexception.kmm.navigation.di.initKoin
import org.koin.android.ext.koin.androidContext

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MainApplication)
        }
    }
}
