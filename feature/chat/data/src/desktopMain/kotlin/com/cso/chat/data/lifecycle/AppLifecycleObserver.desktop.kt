package com.cso.chat.data.lifecycle

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

actual class AppLifecycleObserver {
    // Don't disconnect websocket in Desktop
    actual val isInForeground: Flow<Boolean>
        get() = flowOf(true)
}