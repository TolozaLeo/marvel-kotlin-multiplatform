package dev.leotoloza.marvelkmmapp.android.di

import app.cash.sqldelight.db.SqlDriver
import dev.leotoloza.marvelkmmapp.cache.MarvelDatabase
import dev.leotoloza.marvelkmmapp.data.local.DatabaseDriverFactory
import dev.leotoloza.marvelkmmapp.data.local.CharacterLocalDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localDatabaseModule = module {
    // 1) Proveo DatabaseDriverFactory con el contexto Android
    single { DatabaseDriverFactory(androidContext()) }

    // 2) Creo el SqlDriver usando la factory
    single<SqlDriver> {
        get<DatabaseDriverFactory>().createDriver()
    }

    // 3) Instancio MarvelDatabase con ese driver
    single {
        MarvelDatabase( driver = get() )
    }

    // 4) DAO
    single {
        CharacterLocalDataSource( get() )
    }
}