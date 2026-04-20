package com.cso.chat.presentation.chat_detail

import com.cso.core.presentation.util.UiText

sealed interface ChatDetailEvent {
    data object OnChatLeft : ChatDetailEvent
    data class OnError(val error: UiText) : ChatDetailEvent
}