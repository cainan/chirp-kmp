package com.cso.chat.data.message

import com.cso.chat.data.mappers.toDomain
import com.cso.chat.data.mappers.toEntity
import com.cso.chat.database.ChirpChatDatabase
import com.cso.chat.domain.message.ChatMessageService
import com.cso.chat.domain.message.MessageRepository
import com.cso.chat.domain.model.ChatMessage
import com.cso.chat.domain.model.ChatMessageDeliveryStatus
import com.cso.chat.domain.model.MessageWithSender
import com.cso.core.data.database.safeDatabaseUpdate
import com.cso.core.domain.util.DataError
import com.cso.core.domain.util.EmptyResult
import com.cso.core.domain.util.Result
import com.cso.core.domain.util.onSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlin.time.Clock

class OfflineFirstMessageRepository(
    private val database: ChirpChatDatabase,
    private val chatMessageService: ChatMessageService
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

    override suspend fun fetchMessages(
        chatId: String,
        before: String?
    ): Result<List<ChatMessage>, DataError> {
        return chatMessageService
            .fetchMessages(chatId, before)
            .onSuccess { messages ->
                return safeDatabaseUpdate {
                    database.chatMessageDao.upsertMessagesAndSyncIfNecessary(
                        chatId = chatId,
                        serverMessages = messages.map { it.toEntity() },
                        pageSize = ChatMessageConstants.PAGE_SIZE,
                        shouldSync = before == null // Only sync for most recent page
                    )
                    messages
                }
            }
    }

    override fun getMessagesForChat(chatId: String): Flow<List<MessageWithSender>> {
        return database
            .chatMessageDao
            .getMessagesByChatId(chatId)
            .map { messages ->
                messages.map { it.toDomain() }
            }
    }

}