package com.cso.chirp

import androidx.compose.runtime.Composable
import com.cso.auth.presentation.register.RegisterRoot
import com.cso.core.designsystem.theme.ChirpTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    ChirpTheme {
        RegisterRoot(
            onRegisterSuccess = {}
        )
    }
}