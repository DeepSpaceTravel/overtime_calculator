package org.example.project.databaseFactory

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import org.example.project.AppDatabase

class IOSDatabaseDriverFactory(): DatabaseDriverFactory  {
    override fun createDriver(): SqlDriver {
        return NativeSqliteDriver(AppDatabase.Schema, "info.db")
    }
}