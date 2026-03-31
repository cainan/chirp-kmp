package com.cso.core.data.di

import com.cso.core.data.auth.DataStoreSessionStorage
import com.cso.core.data.auth.KtorAuthService
import com.cso.core.data.logging.KermitLogger
import com.cso.core.data.networking.HttpClientFactory
import com.cso.core.domain.auth.AuthService
import com.cso.core.domain.auth.SessionStorage
import com.cso.core.domain.logging.ChirpLogger
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformCoreDataModule: Module

val coreDataModule = module {
    includes(platformCoreDataModule)
    single<ChirpLogger> { KermitLogger }
    single {
        HttpClientFactory(get(), get()).create(get())
    }
    singleOf(::KtorAuthService) bind AuthService::class
    singleOf(::DataStoreSessionStorage) bind SessionStorage::class
}