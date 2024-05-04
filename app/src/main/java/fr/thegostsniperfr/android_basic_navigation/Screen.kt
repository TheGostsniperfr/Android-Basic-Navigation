package fr.thegostsniperfr.android_basic_navigation

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object Login: Screen(route = "login_screen")
    object News: Screen(route = "news_screen")
}