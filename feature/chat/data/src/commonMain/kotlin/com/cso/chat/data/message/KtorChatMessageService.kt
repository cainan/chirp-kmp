package com.cso.chat.data.message

import com.cso.chat.data.dto.ChatMessageDto
import com.cso.chat.data.mappers.toDomain
import com.cso.chat.domain.message.ChatMessageService
import com.cso.chat.domain.model.ChatMessage
import com.cso.core.data.networking.get
import com.cso.core.domain.util.DataError
import com.cso.core.domain.util.Result
import com.cso.core.domain.util.map
import io.ktor.client.HttpClient

class KtorChatMessageService(
    private val httpClient: HttpClient
) : ChatMessageService {

    override suspend fun fetchMessages(
        chatId: String,
        before: String?
    ): Result<List<ChatMessage>, DataError.Remote> {
        return httpClient.get<List<ChatMessageDto>>(
            route = "/chat/$chatId/messages",
            queryParams = buildMap {
                this["pageSize"] = ChatMessageConstants.PAGE_SIZE
                if (before != null) {
                    this["before"] = before
                }
            }
        ).map { chatMessageDtoList ->
            chatMessageDtoList.map {
                it.toDomain()
            }
        }
    }
}