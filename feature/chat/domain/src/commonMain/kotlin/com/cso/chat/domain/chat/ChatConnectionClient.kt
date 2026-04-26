package com.cso.chat.domain.chat

import com.cso.chat.domain.model.ChatMessage
import com.cso.chat.domain.model.ConnectionState
import com.cso.core.domain.util.DataError
import com.cso.core.domain.util.EmptyResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface ChatConnectionClient {
    val chatMessages: Flow<ChatMessage>
    val connectionState: StateFlow<ConnectionState>
    suspend fun sendChatMessage(message: ChatMessage): EmptyResult<DataError.Connection>
}