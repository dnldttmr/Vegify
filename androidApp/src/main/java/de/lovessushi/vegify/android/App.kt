package de.lovessushi.vegify.android

import android.app.Application
import de.lovessushi.vegify.android.di.androidModule
import de.lovessushi.vegify.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(appModule() + androidModule)
        }
    }
}