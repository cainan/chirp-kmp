package com.cso.chat.domain.chat

import com.cso.chat.domain.model.Chat
import com.cso.chat.domain.model.ChatInfo
import com.cso.chat.domain.model.ChatParticipant
import com.cso.core.domain.util.DataError
import com.cso.core.domain.util.EmptyResult
import com.cso.core.domain.util.Result
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    fun getChats(): Flow<List<Chat>>

    fun getChatInfoById(chatId: String): Flow<ChatInfo>

    fun getActiveParticipantsByChatId(chatId: String): Flow<List<ChatParticipant>>

    suspend fun fetchChats(): Result<List<Chat>, DataError.Remote>

    suspend fun fetchChatById(chatId: String): EmptyResult<DataError.Remote>

    suspend fun createChat(otherUserIds: List<String>): Result<Chat, DataError.Remote>

    suspend fun leaveChat(chatId: String): EmptyResult<DataError.Remote>

    suspend fun addParticipantsToChat(
        chatId: String,
        userIds: List<String>
    ): Result<Chat, DataError.Remote>

}