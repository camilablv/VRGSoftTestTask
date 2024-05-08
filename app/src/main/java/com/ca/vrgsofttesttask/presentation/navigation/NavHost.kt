package com.ca.vrgsofttesttask.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ca.vrgsofttesttask.presentation.screens.topposts.TopPostsScreen

internal sealed class Routes(val route: String) {
    object Posts : Routes("posts")
}

@Composable
fun AppNavHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Routes.Posts.route
    ) {
        composable(Routes.Posts.route) {
            TopPostsScreen()
        }
    }
}