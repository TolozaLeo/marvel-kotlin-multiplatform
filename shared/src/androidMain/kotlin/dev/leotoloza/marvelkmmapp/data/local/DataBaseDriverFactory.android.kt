package dev.leotoloza.marvelkmmapp.data.local

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import dev.leotoloza.marvelkmmapp.cache.MarvelDatabase

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(schema = MarvelDatabase.Schema, context = context, name = "MarvelDatabase.db")
    }
}