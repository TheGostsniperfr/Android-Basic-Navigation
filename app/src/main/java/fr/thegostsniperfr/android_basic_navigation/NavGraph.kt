package fr.thegostsniperfr.android_basic_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import fr.thegostsniperfr.android_basic_navigation.screens.HelloScreen
import fr.thegostsniperfr.android_basic_navigation.screens.HomeScreen
import fr.thegostsniperfr.android_basic_navigation.screens.IteratorBtnScreen


@Composable
fun SetupNavGraph(
    navController: NavHostController,
) {
    NavHost(navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.Hello.route
        ) {
            HelloScreen(navController = navController)
        }
        composable(route = Screen.IteratorBtn.route
        ) {
            IteratorBtnScreen()
        }
    }
}