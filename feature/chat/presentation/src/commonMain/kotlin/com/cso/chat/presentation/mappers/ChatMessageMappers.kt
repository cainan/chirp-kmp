package com.cso.chat.presentation.mappers

import com.cso.chat.domain.model.MessageWithSender
import com.cso.chat.presentation.model.MessageUi
import com.cso.chat.presentation.util.DateUtils
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun MessageWithSender.toUi(
    localUserId: String,
): MessageUi {
    val isFromLocalUser = this.sender.userId == localUserId
    return if (isFromLocalUser) {
        MessageUi.LocalUserMessage(
            id = message.id,
            content = message.content,
            deliveryStatus = message.deliveryStatus,
            formattedSentTime = DateUtils.formatMessageTime(instant = message.createdAt)
        )
    } else {
        MessageUi.OtherUserMessage(
            id = message.id,
            content = message.content,
            formattedSentTime = DateUtils.formatMessageTime(instant = message.createdAt),
            sender = sender.toUi()
        )
    }
}

fun List<MessageWithSender>.toUiList(localUserId: String): List<MessageUi> {
    return this
        .sortedByDescending { it.message.createdAt }
        .groupBy {
            it.message.createdAt.toLocalDateTime(TimeZone.currentSystemDefault()).date
        }
        .flatMap { (date, messages) ->
            messages.map { it.toUi(localUserId) } + MessageUi.DateSeparator(
                id = date.toString(),
                date = DateUtils.formatDateSeparator(date)
            )
        }
}