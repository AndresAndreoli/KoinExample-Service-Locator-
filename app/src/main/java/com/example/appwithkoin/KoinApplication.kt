package com.example.appwithkoin

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/*
    Para utilizar Koin necesitamos crear una clase que herede de Application ya que ahí es donde
    vamos a inicializar nuestro inyector. Creamos la clase y la registramos en el Android Manifest.

    Manifest -> android:name=".KoinApplication"
 */

class KoinApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Log Koin into Android logger
            androidLogger()

            // Reference Android context
            androidContext(this@KoinApplication)

            // Load modules
            modules(presenterModule, providersModule)
        }
    }
}