package dev.leotoloza.marvelkmmapp

import dev.leotoloza.marvelkmmapp.data.di.appModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(appModule)
    }
}