package com.cso.chat.presentation.manage_chat

sealed interface ManageChatEvent {
    data object OnMembersAdded : ManageChatEvent
}