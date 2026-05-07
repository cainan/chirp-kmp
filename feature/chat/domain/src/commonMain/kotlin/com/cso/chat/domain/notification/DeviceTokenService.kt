package com.cso.chat.domain.notification

import com.cso.core.domain.util.DataError
import com.cso.core.domain.util.EmptyResult

interface DeviceTokenService {

    suspend fun registerToken(
        token: String,
        platform: String
    ): EmptyResult<DataError.Remote>

    suspend fun unregisterToken(
        token: String
    ): EmptyResult<DataError.Remote>

}