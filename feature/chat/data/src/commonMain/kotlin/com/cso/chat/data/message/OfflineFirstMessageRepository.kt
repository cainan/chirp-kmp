package com.cso.chat.data.message

import com.cso.chat.database.ChirpChatDatabase
import com.cso.chat.domain.message.MessageRepository
import com.cso.chat.domain.model.ChatMessageDeliveryStatus
import com.cso.core.data.database.safeDatabaseUpdate
import com.cso.core.domain.util.DataError
import com.cso.core.domain.util.EmptyResult
import kotlin.time.Clock

class OfflineFirstMessageRepository(
    private val database: ChirpChatDatabase
) : MessageRepository {

    override suspend fun updateMessageDeliveryStatus(
        messageId: String,
        status: ChatMessageDeliveryStatus
    ): EmptyResult<DataError.Local> {
        return safeDatabaseUpdate {
            database.chatMessageDao.updateDeliveryStatus(
                messageId = messageId,
                status = status.name,
                timestamp = Clock.System.now().toEpochMilliseconds()
            )
        }
    }

}