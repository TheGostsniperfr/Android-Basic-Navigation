package com.example.lab4_hello_world

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lab4_hello_world.screens.HelloScreen
import com.example.lab4_hello_world.screens.HomeScreen
import com.example.lab4_hello_world.screens.IteratorBtnScreen

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