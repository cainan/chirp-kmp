package com.cso.chat.data.notification

import com.cso.chat.data.dto.request.RegisterDeviceTokenRequest
import com.cso.chat.domain.notification.DeviceTokenService
import com.cso.core.data.networking.delete
import com.cso.core.data.networking.post
import com.cso.core.domain.util.DataError
import com.cso.core.domain.util.EmptyResult
import io.ktor.client.HttpClient

class KtorDeviceTokenService(
    private val httpClient: HttpClient
) : DeviceTokenService {
    override suspend fun registerToken(
        token: String,
        platform: String
    ): EmptyResult<DataError.Remote> {
        return httpClient.post(
            route = "/notification/register",
            body = RegisterDeviceTokenRequest(
                token = token,
                platform = platform
            )
        )
    }

    override suspend fun unregisterToken(token: String): EmptyResult<DataError.Remote> {
        return httpClient.delete(
            route = "/notification/$token"
        )
    }
}