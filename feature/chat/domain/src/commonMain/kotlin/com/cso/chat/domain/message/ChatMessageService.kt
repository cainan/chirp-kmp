package com.cso.chat.domain.message

import com.cso.chat.domain.model.ChatMessage
import com.cso.core.domain.util.DataError
import com.cso.core.domain.util.EmptyResult
import com.cso.core.domain.util.Result

interface ChatMessageService {
    suspend fun fetchMessages(
        chatId: String,
        before: String? = null
    ): Result<List<ChatMessage>, DataError.Remote>

    suspend fun deleteMessage(
        messageId: String
    ): EmptyResult<DataError.Remote>

}