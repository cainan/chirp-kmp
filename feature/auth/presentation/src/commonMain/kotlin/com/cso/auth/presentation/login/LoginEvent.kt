package com.cso.auth.presentation.login

sealed interface LoginEvent {
    data object Success : LoginEvent
}