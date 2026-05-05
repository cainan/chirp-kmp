package com.cso.chat.domain.participant

import com.cso.chat.domain.model.ChatParticipant
import com.cso.core.domain.util.DataError
import com.cso.core.domain.util.EmptyResult
import com.cso.core.domain.util.Result

interface ChatParticipantRepository {
    suspend fun fetchLocalParticipant(): Result<ChatParticipant, DataError>

    suspend fun uploadProfilePicture(
        imageBytes: ByteArray,
        mimeType: String
    ): EmptyResult<DataError.Remote>

    suspend fun deleteProfilePicture(): EmptyResult<DataError.Remote>
}