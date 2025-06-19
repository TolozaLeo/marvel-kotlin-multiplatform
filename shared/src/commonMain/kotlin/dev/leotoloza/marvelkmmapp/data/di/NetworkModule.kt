package dev.leotoloza.marvelkmmapp.data.di

import dev.leotoloza.marvelkmmapp.data.network.getHttpClient
import io.ktor.client.HttpClient
import org.koin.dsl.module

val networkModule = module {
    // Usa expect/actual para crear el HttpClient
    single<HttpClient> { getHttpClient() }
}