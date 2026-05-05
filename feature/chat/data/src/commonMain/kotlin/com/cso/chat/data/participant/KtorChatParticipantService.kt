package com.cso.chat.data.participant

import com.cso.chat.data.dto.ChatParticipantDto
import com.cso.chat.data.dto.request.ConfirmProfilePictureRequest
import com.cso.chat.data.dto.response.ProfilePictureUploadUrlsResponse
import com.cso.chat.data.mappers.toDomain
import com.cso.chat.domain.model.ChatParticipant
import com.cso.chat.domain.model.ProfilePictureUploadUrls
import com.cso.chat.domain.participant.ChatParticipantService
import com.cso.core.data.networking.delete
import com.cso.core.data.networking.get
import com.cso.core.data.networking.post
import com.cso.core.data.networking.safeCall
import com.cso.core.domain.util.DataError
import com.cso.core.domain.util.EmptyResult
import com.cso.core.domain.util.Result
import com.cso.core.domain.util.map
import io.ktor.client.HttpClient
import io.ktor.client.request.header
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.request.url

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

    override suspend fun getProfilePictureUploadUrl(mimeType: String): Result<ProfilePictureUploadUrls, DataError.Remote> {
        return httpClient.post<Unit, ProfilePictureUploadUrlsResponse>(
            route = "/participants/profile-picture-upload",
            queryParams = mapOf(
                "mimeType" to mimeType
            ),
            body = Unit
        ).map { it.toDomain() }
    }

    override suspend fun uploadProfilePicture(
        uploadUrl: String,
        imageBytes: ByteArray,
        headers: Map<String, String>
    ): EmptyResult<DataError.Remote> {
        return safeCall {
            httpClient.put {
                url(uploadUrl)
                headers.forEach { (key, value) ->
                    header(key, value)
                }
                setBody(imageBytes)
            }
        }
    }

    override suspend fun confirmProfilePictureUpload(publicUrl: String): EmptyResult<DataError.Remote> {
        return httpClient.post<ConfirmProfilePictureRequest, Unit>(
            route = "/participants/confirm-profile-picture",
            body = ConfirmProfilePictureRequest(publicUrl)
        )
    }

    override suspend fun deleteProfilePicture(): EmptyResult<DataError.Remote> {
        return httpClient.delete(
            route = "/participants/profile-picture"
        )
    }
}