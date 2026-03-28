package com.cso.chirp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.cso.chirp.navigation.DeepLinkListener
import com.cso.chirp.navigation.NavigationRoot
import com.cso.core.designsystem.theme.ChirpTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    ChirpTheme {
        val navController = rememberNavController()
        DeepLinkListener(navController)
        NavigationRoot(navController)
    }
}