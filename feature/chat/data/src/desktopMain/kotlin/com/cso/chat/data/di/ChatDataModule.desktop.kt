package com.cso.chat.data.di

import com.cso.chat.data.lifecycle.AppLifecycleObserver
import com.cso.chat.data.network.ConnectionErrorHandler
import com.cso.chat.data.network.ConnectivityObserver
import com.cso.chat.data.notification.FirebasePushNotificationService
import com.cso.chat.database.DatabaseFactory
import com.cso.chat.domain.notification.PushNotificationService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val platformChatDataModule = module {
    singleOf(::DatabaseFactory)
    singleOf(::ConnectionErrorHandler)
    singleOf(::ConnectivityObserver)
    singleOf(::AppLifecycleObserver)
    singleOf(::FirebasePushNotificationService) bind PushNotificationService::class
}