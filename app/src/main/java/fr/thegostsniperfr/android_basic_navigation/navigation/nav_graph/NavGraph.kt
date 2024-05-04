package fr.thegostsniperfr.android_basic_navigation.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import fr.thegostsniperfr.android_basic_navigation.navigation.HOME_ROUTE
import fr.thegostsniperfr.android_basic_navigation.navigation.ROOT_ROUTE
import fr.thegostsniperfr.android_basic_navigation.navigation.Screen


@Composable
fun SetupNavGraph(
    navController: NavHostController,
) {
    NavHost(navController = navController,
        startDestination = HOME_ROUTE,
        route = ROOT_ROUTE

    ) {
        homeNavGraph(navController = navController)
        authNavGraph(navController = navController)
    }
}