package com.cso.chat.presentation.create_chat

import com.cso.chat.domain.model.Chat

sealed interface CreateChatEvent {
    data class OnChatCreated(val chat: Chat) : CreateChatEvent
}