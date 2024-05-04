package fr.thegostsniperfr.android_basic_navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
        composable(
            route = Screen.Hello.route,
            arguments = listOf(
                navArgument(HOME_ARGUMENT_KEY1) {
                    type = NavType.StringType
                },
                navArgument(HOME_ARGUMENT_KEY2) {
                    type = NavType.IntType
                }
            )
        ) {
            Log.d("Args", it.arguments?.getString(HOME_ARGUMENT_KEY1).toString())
            Log.d("Args", it.arguments?.getInt(HOME_ARGUMENT_KEY2).toString())
            HelloScreen(navController = navController)
        }
        composable(route = Screen.IteratorBtn.route
        ) {
            IteratorBtnScreen()
        }
    }
}