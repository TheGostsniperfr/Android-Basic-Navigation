package fr.thegostsniperfr.android_basic_navigation.navigation

const val ROOT_ROUTE = "root"
const val AUTHENTICATION_ROUTE = "authentication"
const val HOME_ROUTE = "home"


sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object News: Screen(route = "news_screen")
    object Login: Screen(route = "login_screen")
    object Register: Screen(route = "register_screen")
}