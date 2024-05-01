package fr.thegostsniperfr.android_basic_navigation

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object Hello: Screen("hello_screen")
    object IteratorBtn: Screen("iterator_screen")
}