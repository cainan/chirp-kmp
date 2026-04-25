package com.cso.chat.data.di

import com.cso.chat.data.lifecycle.AppLifecycleObserver
import com.cso.chat.data.network.ConnectionErrorHandler
import com.cso.chat.data.network.ConnectivityObserver
import com.cso.chat.database.DatabaseFactory
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformChatDataModule = module {
    single { DatabaseFactory() }
    singleOf(::AppLifecycleObserver)
    singleOf(::ConnectivityObserver)
    singleOf(::ConnectionErrorHandler)
}