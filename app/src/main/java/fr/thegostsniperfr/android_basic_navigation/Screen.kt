package fr.thegostsniperfr.android_basic_navigation

const val HOME_ARGUMENT_KEY1 = "name";
const val HOME_ARGUMENT_KEY2 = "id";

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")

    object Hello: Screen("hello_screen/{$HOME_ARGUMENT_KEY1}/{$HOME_ARGUMENT_KEY2}") {
//        fun passName(name: String): String {
//            return this.route.replace(oldValue = "{$HOME_ARGUMENT_KEY1}", newValue = name);
//        }

        fun passNameAndId(name: String, id: Int) : String {
            return this.route
                .replace(oldValue = "{$HOME_ARGUMENT_KEY1}", newValue = name)
                .replace(oldValue = "{$HOME_ARGUMENT_KEY2}", newValue = id.toString())

            /*
                    For optional args, it's basically the same as an url
             */
        }
    }

    object IteratorBtn: Screen("iterator_screen")
}