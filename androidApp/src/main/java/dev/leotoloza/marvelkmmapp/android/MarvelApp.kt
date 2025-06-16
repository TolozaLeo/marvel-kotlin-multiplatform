package dev.leotoloza.marvelkmmapp.android

import android.app.Application
import dev.leotoloza.marvelkmmapp.android.di.viewModelModule
import dev.leotoloza.marvelkmmapp.data.di.networkModule
import dev.leotoloza.marvelkmmapp.data.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MarvelApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MarvelApp)
            modules(listOf(networkModule, repositoryModule, viewModelModule,))
        }
    }
}