package com.cso.core.data.mappers

import com.cso.core.data.dto.AuthInfoSerializable
import com.cso.core.data.dto.UserSerializable
import com.cso.core.domain.auth.AuthInfo
import com.cso.core.domain.auth.User

fun AuthInfoSerializable.toDomain(): AuthInfo {
    return AuthInfo(
        accessToken = accessToken,
        refreshToken = refreshToken,
        user = user.toDomain()
    )
}

fun UserSerializable.toDomain(): User {
    return User(
        id = id,
        email = email,
        username = username,
        hasVerifiedEmail = hasVerifiedEmail,
        profilePictureUrl = profilePictureUrl
    )
}