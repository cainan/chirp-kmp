package com.cso.chirp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.cso.chirp.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Chirp"
        ) {
            App()
        }
    }
}