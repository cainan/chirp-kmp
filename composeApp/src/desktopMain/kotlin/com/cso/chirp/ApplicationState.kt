package com.cso.chirp

import com.cso.chirp.windows.WindowState

data class ApplicationState(
    val windows: List<WindowState> = listOf(WindowState())
)