package com.cso.chat.data.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.cso.chat.data.chat.KtorChatParticipantService
import com.cso.chat.data.chat.KtorChatService
import com.cso.chat.data.chat.OfflineFirstChatRepository
import com.cso.chat.database.DatabaseFactory
import com.cso.chat.domain.chat.ChatParticipantService
import com.cso.chat.domain.chat.ChatRepository
import com.cso.chat.domain.chat.ChatService
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
}