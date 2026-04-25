package com.cso.chat.domain.message

import com.cso.chat.domain.model.ChatMessage
import com.cso.chat.domain.model.ChatMessageDeliveryStatus
import com.cso.chat.domain.model.MessageWithSender
import com.cso.core.domain.util.DataError
import com.cso.core.domain.util.EmptyResult
import com.cso.core.domain.util.Result
import kotlinx.coroutines.flow.Flow

interface MessageRepository {

    suspend fun updateMessageDeliveryStatus(
        messageId: String,
        status: ChatMessageDeliveryStatus
    ): EmptyResult<DataError.Local>

    suspend fun fetchMessages(
        chatId: String,
        before: String? = null
    ): Result<List<ChatMessage>, DataError>

    fun getMessagesForChat(chatId: String): Flow<List<MessageWithSender>>
}