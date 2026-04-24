package com.cso.chat.domain.error

import com.cso.core.domain.util.Error

enum class ConnectionError : Error {
    NOT_CONNECTED,
    MESSAGE_SEND_FAILED
}