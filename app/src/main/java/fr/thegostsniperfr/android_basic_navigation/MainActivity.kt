package fr.thegostsniperfr.android_basic_navigation

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.NavHostController
import fr.thegostsniperfr.android_basic_navigation.screens.HomeScreen
import fr.thegostsniperfr.android_basic_navigation.ui.theme.Android_Basic_Navigation_Theme

class MainActivity : ComponentActivity() {

    lateinit var navController : NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_Basic_Navigation_Theme {
                HomeScreen(
                    onBluetoothStateChange = {
                        println("bluetooth state changed")
                    }
                )
            }
        }
    }
}

