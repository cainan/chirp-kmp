package com.cso.chat.data.mappers

import com.cso.chat.data.dto.response.ProfilePictureUploadUrlsResponse
import com.cso.chat.domain.model.ProfilePictureUploadUrls

fun ProfilePictureUploadUrlsResponse.toDomain(): ProfilePictureUploadUrls {
    return ProfilePictureUploadUrls(
        uploadUrl = uploadUrl,
        publicUrl = publicUrl,
        headers = headers
    )
}