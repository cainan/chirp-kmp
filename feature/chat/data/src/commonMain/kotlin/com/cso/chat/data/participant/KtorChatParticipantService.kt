package com.cso.chat.data.participant

import com.cso.chat.data.dto.ChatParticipantDto
import com.cso.chat.data.mappers.toDomain
import com.cso.chat.domain.model.ChatParticipant
import com.cso.chat.domain.participant.ChatParticipantService
import com.cso.core.data.networking.get
import com.cso.core.domain.util.DataError
import com.cso.core.domain.util.Result
import com.cso.core.domain.util.map
import io.ktor.client.HttpClient

class KtorChatParticipantService(
    private val httpClient: HttpClient
) : ChatParticipantService {

    override suspend fun searchParticipant(query: String): Result<ChatParticipant, DataError.Remote> {
        return httpClient.get<ChatParticipantDto>(
            route = "/participants",
            queryParams = mapOf(
                "query" to query
            )
        ).map {
            it.toDomain()
        }
    }

    override suspend fun getLocalParticipant(): Result<ChatParticipant, DataError.Remote> {
        return httpClient.get<ChatParticipantDto>(
            route = "/participants"
        ).map {
            it.toDomain()
        }
    }
}