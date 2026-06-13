package com.cso.chirp

import androidx.compose.ui.window.TrayState
import com.cso.chirp.windows.WindowState
import com.cso.core.domain.preferences.ThemePreference

data class ApplicationState(
    val windows: List<WindowState> = listOf(WindowState()),
    val themePreference: ThemePreference = ThemePreference.SYSTEM,
    val trayState: TrayState = TrayState()
)