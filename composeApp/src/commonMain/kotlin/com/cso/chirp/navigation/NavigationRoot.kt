package com.cso.chirp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.cso.auth.presentation.navigation.AuthGraphRoutes
import com.cso.auth.presentation.navigation.authGraph
import com.cso.chat.presentation.chat_list.ChatListRoute
import com.cso.chat.presentation.navigation.ChatGraphRoutes
import com.cso.chat.presentation.navigation.chatGraph

@Composable
fun NavigationRoot(
    navController: NavHostController,
    startDestination: Any
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        authGraph(
            navController = navController,
            onLoginSuccess = {
                navController.navigate(ChatGraphRoutes.Graph) {
                    popUpTo(AuthGraphRoutes.Graph) {
                        inclusive = true
                    }
                }
            }
        )

        chatGraph(
            navController = navController
        )

    }
}