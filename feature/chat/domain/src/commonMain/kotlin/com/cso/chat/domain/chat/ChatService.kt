package com.cso.chat.domain.chat

import com.cso.chat.domain.model.Chat
import com.cso.core.domain.util.DataError
import com.cso.core.domain.util.Result

interface ChatService {
    suspend fun createChat(
        otherUserIds: List<String>
    ): Result<Chat, DataError.Remote>

    suspend fun getChats(): Result<List<Chat>, DataError.Remote>

    suspend fun getChatById(chatId: String): Result<Chat, DataError.Remote>

}