package com.ca.vrgsofttesttask.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ca.vrgsofttesttask.presentation.screens.fullscreenimage.FullScreenImageScreen
import com.ca.vrgsofttesttask.presentation.screens.topposts.TopPostsScreen

internal sealed class Routes(val route: String) {
    object Posts : Routes("posts")
    object FullScreenImage : Routes("image")
}

const val argName = "imageUrl"

@Composable
fun AppNavHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Routes.Posts.route
    ) {
        composable(Routes.Posts.route) {
            TopPostsScreen { imageUrl ->
                navHostController.navigate("${Routes.FullScreenImage.route}?$argName=$imageUrl")
            }
        }

        composable(
            route = "${Routes.FullScreenImage.route}?$argName={$argName}",
            arguments = listOf(navArgument(argName) { type = NavType.StringType })
        ) {

            FullScreenImageScreen(imageUrl = it.arguments?.getString(argName) ?: "") {
                navHostController.popBackStack()
            }
        }
    }
}