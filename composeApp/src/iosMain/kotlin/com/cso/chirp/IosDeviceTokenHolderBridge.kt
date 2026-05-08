package com.cso.chirp

import com.cso.chat.data.notification.IosDeviceTokenHolder

object IosDeviceTokenHolderBridge {

    fun updateToken(token: String) {
        IosDeviceTokenHolder.updateToken(token)
    }

}