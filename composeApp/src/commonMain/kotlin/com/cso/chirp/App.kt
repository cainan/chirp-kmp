package com.cso.chirp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.cso.auth.presentation.navigation.AuthGraphRoutes
import com.cso.chat.presentation.chat_list.ChatListRoute
import com.cso.chirp.navigation.DeepLinkListener
import com.cso.chirp.navigation.NavigationRoot
import com.cso.core.designsystem.theme.ChirpTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App(
    viewModel: MainViewModel = koinViewModel(),
    onAuthenticationChecked: () -> Unit = {}
) {
    val navController = rememberNavController()
    DeepLinkListener(navController)

    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(state.isCheckingAuth) {
        if (!state.isCheckingAuth) {
            onAuthenticationChecked()
        }
    }

    ChirpTheme {
        if (!state.isCheckingAuth) {
            NavigationRoot(
                navController = navController,
                startDestination = if (state.isLoggedIn) {
                    ChatListRoute
                } else {
                    AuthGraphRoutes.Graph
                }
            )
        }
    }
}