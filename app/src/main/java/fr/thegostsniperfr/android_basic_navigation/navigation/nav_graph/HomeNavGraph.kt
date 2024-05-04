package fr.thegostsniperfr.android_basic_navigation.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import fr.thegostsniperfr.android_basic_navigation.navigation.HOME_ROUTE
import fr.thegostsniperfr.android_basic_navigation.navigation.Screen
import fr.thegostsniperfr.android_basic_navigation.screens.HomeScreen
import fr.thegostsniperfr.android_basic_navigation.screens.NewsScreen

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController,
) {
    navigation(
        startDestination = Screen.Home.route,
        route = HOME_ROUTE
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.News.route
        ) {
            NewsScreen(navController = navController)
        }
    }
}