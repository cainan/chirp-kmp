package com.cso.chat.domain.participant

import com.cso.chat.domain.model.ChatParticipant
import com.cso.core.domain.util.DataError
import com.cso.core.domain.util.Result

interface ChatParticipantRepository {
    suspend fun fetchLocalParticipant(): Result<ChatParticipant, DataError>
}