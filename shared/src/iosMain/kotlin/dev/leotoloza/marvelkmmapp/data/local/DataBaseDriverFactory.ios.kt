package dev.leotoloza.marvelkmmapp.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import dev.leotoloza.marvelkmmapp.chache.MarvelDatabase

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(MarvelDatabase.Schema, "MarvelDatabase.db")
    }
}