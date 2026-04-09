package com.cso.chat.data.chat

import com.cso.chat.data.dto.ChatDto
import com.cso.chat.data.dto.request.CreateChatRequest
import com.cso.chat.data.mappers.toDomain
import com.cso.chat.domain.chat.ChatService
import com.cso.chat.domain.model.Chat
import com.cso.core.data.networking.post
import com.cso.core.domain.util.DataError
import com.cso.core.domain.util.Result
import com.cso.core.domain.util.map
import io.ktor.client.HttpClient

class KtorChatService(
    private val httpClient: HttpClient
) : ChatService {

    override suspend fun createChat(otherUserIds: List<String>): Result<Chat, DataError.Remote> {
        return httpClient.post<CreateChatRequest, ChatDto>(
            route = "/chat",
            body = CreateChatRequest(
                otherUserIds = otherUserIds
            )
        ).map { it.toDomain() }
    }
}