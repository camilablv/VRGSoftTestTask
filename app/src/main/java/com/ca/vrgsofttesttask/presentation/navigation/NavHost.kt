package com.ca.vrgsofttesttask.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.ca.vrgsofttesttask.presentation.screens.fullscreenimage.FullScreenImageScreen
import com.ca.vrgsofttesttask.presentation.screens.topposts.TopPostsScreen
import kotlinx.serialization.Serializable

@Serializable
internal sealed class Screen() {
    @Serializable object Posts : Screen()
    @Serializable data class FullScreenImage(val imageUrl: String) : Screen()
}

@Composable
fun AppNavHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Posts
    ) {
        composable<Screen.Posts> {
            TopPostsScreen { imageUrl ->
                navHostController.navigate(Screen.FullScreenImage(imageUrl))
            }
        }

        composable<Screen.FullScreenImage> {backStackEntry ->
            val route = backStackEntry.toRoute<Screen.FullScreenImage>()
            FullScreenImageScreen(imageUrl = route.imageUrl) {
                navHostController.popBackStack()
            }
        }
    }
}