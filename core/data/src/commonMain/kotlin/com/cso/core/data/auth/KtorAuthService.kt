package com.cso.core.data.auth

import com.cso.core.data.dto.requests.RegisterRequest
import com.cso.core.data.networking.post
import com.cso.core.domain.auth.AuthService
import com.cso.core.domain.util.DataError
import com.cso.core.domain.util.EmptyResult
import io.ktor.client.HttpClient


class KtorAuthService(
    private val httpClient: HttpClient
) : AuthService {
    override suspend fun register(
        email: String,
        username: String,
        password: String
    ): EmptyResult<DataError.Remote> {
        return httpClient.post(
            route = "/auth/register",
            body = RegisterRequest(
                email = email,
                username = username,
                password = password
            )
        )
    }
}