package com.cso.chirp.di

import com.cso.auth.presentation.di.authPresentationModule
import com.cso.chat.data.di.chatDataModule
import com.cso.chat.presentation.di.chatPresentationModule
import com.cso.core.data.di.coreDataModule
import com.cso.core.presentation.di.corePresentationModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            coreDataModule,
            authPresentationModule,
            appModule,
            chatPresentationModule,
            corePresentationModule,
            chatDataModule
        )
    }
}