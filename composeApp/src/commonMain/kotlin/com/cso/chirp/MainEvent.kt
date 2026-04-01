package com.cso.chirp

sealed interface MainEvent {
    data object OnSessionExpired : MainEvent
}