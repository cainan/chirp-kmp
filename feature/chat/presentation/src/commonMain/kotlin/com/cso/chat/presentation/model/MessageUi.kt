package com.cso.chat.presentation.model

import com.cso.chat.domain.model.ChatMessageDeliveryStatus
import com.cso.core.designsystem.components.avatar.ChatParticipantUi
import com.cso.core.presentation.util.UiText

sealed interface MessageUi {
    data class LocalUserMessage(
        val id: String,
        val content: String,
        val deliveryStatus: ChatMessageDeliveryStatus,
        val isMenuOpen: Boolean,
        val formattedSentTime: UiText
    ) : MessageUi

    data class OtherUserMessage(
        val id: String,
        val content: String,
        val formattedSentTime: UiText,
        val sender: ChatParticipantUi
    ) : MessageUi

    data class DateSeparator(
        val id: String,
        val date: UiText,
    ) : MessageUi
}