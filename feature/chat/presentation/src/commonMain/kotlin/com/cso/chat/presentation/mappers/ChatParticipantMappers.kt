package com.cso.chat.presentation.mappers

import com.cso.chat.domain.model.ChatParticipant
import com.cso.core.designsystem.components.avatar.ChatParticipantUi

fun ChatParticipant.toUi(): ChatParticipantUi {
    return ChatParticipantUi(
        id = userId,
        username = username,
        initials = initials,
        imageUrl = profilePictureUrl
    )
}