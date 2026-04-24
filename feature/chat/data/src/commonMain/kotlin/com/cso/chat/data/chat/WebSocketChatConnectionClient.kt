package com.cso.chat.data.chat

import com.cso.chat.data.dto.websocket.WebSocketMessageDto
import com.cso.chat.data.mappers.toNewMessage
import com.cso.chat.data.network.KtorWebSocketConnector
import com.cso.chat.database.ChirpChatDatabase
import com.cso.chat.domain.chat.ChatConnectionClient
import com.cso.chat.domain.chat.ChatRepository
import com.cso.chat.domain.error.ConnectionError
import com.cso.chat.domain.message.MessageRepository
import com.cso.chat.domain.model.ChatMessage
import com.cso.chat.domain.model.ChatMessageDeliveryStatus
import com.cso.core.domain.auth.SessionStorage
import com.cso.core.domain.util.EmptyResult
import com.cso.core.domain.util.onFailure
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.json.Json

class WebSocketChatConnectionClient(
    private val webSocketConnector: KtorWebSocketConnector,
    private val chatRepository: ChatRepository,
    private val database: ChirpChatDatabase,
    private val sessionStorage: SessionStorage,
    private val json: Json,
    private val messageRepository: MessageRepository
) : ChatConnectionClient {

    override val chatMessages: Flow<ChatMessage>
        get() = TODO()

    override val connectionState = webSocketConnector.connectionState

    override suspend fun sendChatMessage(message: ChatMessage): EmptyResult<ConnectionError> {
        val outgoingDto = message.toNewMessage()

        val webSocketMessage = WebSocketMessageDto(
            type = outgoingDto.type.name,
            payload = json.encodeToString(outgoingDto)
        )

        val rawJsonPayload = json.encodeToString(webSocketMessage)

        return webSocketConnector.sendMessage(rawJsonPayload)
            .onFailure { error ->
                messageRepository.updateMessageDeliveryStatus(
                    messageId = message.id,
                    status = ChatMessageDeliveryStatus.FAILED
                )
            }
    }
}