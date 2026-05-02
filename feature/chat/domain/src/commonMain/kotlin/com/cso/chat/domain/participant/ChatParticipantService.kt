package com.cso.chat.domain.participant

import com.cso.chat.domain.model.ChatParticipant
import com.cso.core.domain.util.DataError
import com.cso.core.domain.util.Result

interface ChatParticipantService {
    suspend fun searchParticipant(
        query: String
    ): Result<ChatParticipant, DataError.Remote>

    suspend fun getLocalParticipant(): Result<ChatParticipant, DataError.Remote>
}