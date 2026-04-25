package com.cso.chat.data.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.cso.chat.data.chat.KtorChatParticipantService
import com.cso.chat.data.chat.KtorChatService
import com.cso.chat.data.chat.OfflineFirstChatRepository
import com.cso.chat.data.chat.WebSocketChatConnectionClient
import com.cso.chat.data.message.OfflineFirstMessageRepository
import com.cso.chat.data.network.KtorWebSocketConnector
import com.cso.chat.database.DatabaseFactory
import com.cso.chat.domain.chat.ChatConnectionClient
import com.cso.chat.domain.chat.ChatParticipantService
import com.cso.chat.domain.chat.ChatRepository
import com.cso.chat.domain.chat.ChatService
import com.cso.chat.domain.message.MessageRepository
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformChatDataModule: Module
val chatDataModule = module {

    includes(platformChatDataModule)

    single {
        get<DatabaseFactory>()
            .create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }

    singleOf(::KtorChatParticipantService) bind ChatParticipantService::class
    singleOf(::KtorChatService) bind ChatService::class
    singleOf(::OfflineFirstChatRepository) bind ChatRepository::class
    singleOf(::OfflineFirstMessageRepository) bind MessageRepository::class
    singleOf(::WebSocketChatConnectionClient) bind ChatConnectionClient::class
    singleOf(::KtorWebSocketConnector)

    single {
        Json {
            ignoreUnknownKeys = true
        }
    }
}