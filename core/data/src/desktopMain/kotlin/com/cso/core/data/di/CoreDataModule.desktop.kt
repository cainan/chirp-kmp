package com.cso.core.data.di

import com.cso.core.data.auth.createDataStore
import com.cso.core.data.preferences.DataStoreThemePreferences
import com.cso.core.domain.preferences.ThemePreferences
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val platformCoreDataModule = module {
    single<HttpClientEngine> { OkHttp.create() }
    single {
        createDataStore()
    }
    singleOf(::DataStoreThemePreferences) bind ThemePreferences::class
}