package dev.leotoloza.marvelkmmapp.android

import android.app.Application
import dev.leotoloza.marvelkmmapp.data.di.appModule
import org.koin.core.context.startKoin
class MarvelApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
        }
    }
}