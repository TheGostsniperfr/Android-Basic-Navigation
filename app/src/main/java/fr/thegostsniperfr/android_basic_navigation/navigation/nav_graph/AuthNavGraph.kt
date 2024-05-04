package fr.thegostsniperfr.android_basic_navigation.navigation.nav_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import fr.thegostsniperfr.android_basic_navigation.navigation.AUTHENTICATION_ROUTE
import fr.thegostsniperfr.android_basic_navigation.navigation.Screen
import fr.thegostsniperfr.android_basic_navigation.screens.LoginScreen
import fr.thegostsniperfr.android_basic_navigation.screens.RegisterScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screen.Login.route,
        route = AUTHENTICATION_ROUTE
    ) {
        composable(route = Screen.Login.route
        ) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.Register.route
        ) {
            RegisterScreen(navController = navController)
        }
    }
}