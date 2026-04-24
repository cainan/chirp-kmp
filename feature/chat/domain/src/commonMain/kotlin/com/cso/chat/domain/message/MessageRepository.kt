package com.cso.chat.domain.message

import com.cso.chat.domain.model.ChatMessageDeliveryStatus
import com.cso.core.domain.util.DataError
import com.cso.core.domain.util.EmptyResult

interface MessageRepository {

    suspend fun updateMessageDeliveryStatus(
        messageId: String,
        status: ChatMessageDeliveryStatus
    ): EmptyResult<DataError.Local>

}