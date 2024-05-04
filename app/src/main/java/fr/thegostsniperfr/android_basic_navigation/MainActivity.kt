package fr.thegostsniperfr.android_basic_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import fr.thegostsniperfr.android_basic_navigation.navigation.nav_graph.SetupNavGraph
import fr.thegostsniperfr.android_basic_navigation.ui.theme.Android_Basic_Navigation_Theme

class MainActivity : ComponentActivity() {

    lateinit var navController : NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()

            Android_Basic_Navigation_Theme {
                SetupNavGraph(navController = navController)
            }
        }
    }
}

