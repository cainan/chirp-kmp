package com.cso.chat.data.mappers

import com.cso.chat.data.dto.ChatMessageDto
import com.cso.chat.domain.model.ChatMessage
import kotlin.time.Instant

fun ChatMessageDto.toDomain(): ChatMessage {
    return ChatMessage(
        id = id,
        chatId = chatId,
        content = content,
        createdAt = Instant.parse(createdAt),
        senderId = senderId
    )
}