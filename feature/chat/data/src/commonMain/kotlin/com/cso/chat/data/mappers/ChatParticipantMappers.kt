package com.cso.chat.data.mappers

import com.cso.chat.data.dto.ChatParticipantDto
import com.cso.chat.domain.model.ChatParticipant

fun ChatParticipantDto.toDomain(): ChatParticipant {
    return ChatParticipant(
        userId = userId,
        username = username,
        profilePictureUrl = profilePictureUrl
    )
}