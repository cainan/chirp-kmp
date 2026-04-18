package com.cso.chat.data.mappers

import com.cso.chat.data.dto.ChatDto
import com.cso.chat.database.entities.ChatEntity
import com.cso.chat.database.entities.ChatInfoEntity
import com.cso.chat.database.entities.ChatWithParticipants
import com.cso.chat.database.entities.MessageWithSender
import com.cso.chat.domain.model.Chat
import com.cso.chat.domain.model.ChatInfo
import com.cso.chat.domain.model.ChatMessage
import com.cso.chat.domain.model.ChatMessageDeliveryStatus
import com.cso.chat.domain.model.ChatParticipant
import kotlin.time.Instant

typealias DataMessageWithSender = MessageWithSender
typealias DomainMessageWithSender = com.cso.chat.domain.model.MessageWithSender

fun ChatDto.toDomain(): Chat {
    return Chat(
        id = id,
        participants = participants.map { it.toDomain() },
        lastActivityAt = Instant.parse(lastActivityAt),
        lastMessage = lastMessage?.toDomain()
    )
}

fun ChatEntity.toDomain(
    participants: List<ChatParticipant>,
    lastMessage: ChatMessage? = null
): Chat {
    return Chat(
        id = chatId,
        participants = participants,
        lastActivityAt = Instant.fromEpochMilliseconds(lastActivityAt),
        lastMessage = lastMessage
    )
}

fun ChatWithParticipants.toDomain(): Chat {
    return Chat(
        id = chat.chatId,
        participants = participants.map { it.toDomain() },
        lastActivityAt = Instant.fromEpochMilliseconds(chat.lastActivityAt),
        lastMessage = lastMessage?.toDomain()
    )
}

fun Chat.toEntity(): ChatEntity {
    return ChatEntity(
        chatId = id,
        lastActivityAt = lastActivityAt.toEpochMilliseconds()
    )
}

fun DataMessageWithSender.toDomain(): DomainMessageWithSender {
    return DomainMessageWithSender(
        message = message.toDomain(),
        sender = sender.toDomain(),
        deliveryStatus = ChatMessageDeliveryStatus.valueOf(this.message.deliveryStatus)
    )
}

fun ChatInfoEntity.toDomain(): ChatInfo {
    return ChatInfo(
        chat = chat.toDomain(
            participants = this.participants.map { it.toDomain() }
        ),
        messages = messagesWithSenders.map { it.toDomain() }
    )
}