package com.cso.core.data.database

import androidx.sqlite.SQLiteException
import com.cso.core.domain.util.DataError
import com.cso.core.domain.util.DataError.Local.DISK_FULL
import com.cso.core.domain.util.Result

suspend inline fun <T> safeDatabaseUpdate(update: suspend () -> T): Result<T, DataError.Local> {
    return try {
        Result.Success(update())
    } catch (_: SQLiteException) {
        Result.Failure(DISK_FULL)
    }
}