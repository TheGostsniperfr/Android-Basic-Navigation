package fr.thegostsniperfr.android_basic_navigation

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import fr.thegostsniperfr.android_basic_navigation.screens.HomeScreen
import fr.thegostsniperfr.android_basic_navigation.ui.theme.Android_Basic_Navigation_Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_Basic_Navigation_Theme {
                HomeScreen()
            }
        }
    }
}