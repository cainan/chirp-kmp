package com.cso.chat.data.participant

import com.cso.chat.domain.model.ChatParticipant
import com.cso.chat.domain.participant.ChatParticipantRepository
import com.cso.chat.domain.participant.ChatParticipantService
import com.cso.core.domain.auth.SessionStorage
import com.cso.core.domain.util.DataError
import com.cso.core.domain.util.Result
import com.cso.core.domain.util.onSuccess
import kotlinx.coroutines.flow.first

class OfflineFirstChatParticipantRepository(
    private val chatParticipantService: ChatParticipantService,
    private val sessionStorage: SessionStorage
) : ChatParticipantRepository {

    override suspend fun fetchLocalParticipant(): Result<ChatParticipant, DataError> {
        return chatParticipantService
            .getLocalParticipant()
            .onSuccess { participant ->
                val currentAuthInfo = sessionStorage.observeAuthInfo().first()
                sessionStorage.set(
                    currentAuthInfo?.copy(
                        user = currentAuthInfo.user.copy(
                            id = participant.userId,
                            username = participant.username,
                            profilePictureUrl = participant.profilePictureUrl
                        )
                    )
                )
            }
    }

}