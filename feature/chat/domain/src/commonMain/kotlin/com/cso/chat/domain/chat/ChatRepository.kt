package com.cso.chat.domain.chat

import com.cso.chat.domain.model.Chat
import com.cso.core.domain.util.DataError
import com.cso.core.domain.util.Result
import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    fun getChats(): Flow<List<Chat>>
    suspend fun fetchChats(): Result<List<Chat>, DataError.Remote>
}