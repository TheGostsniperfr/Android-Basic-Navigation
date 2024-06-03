package fr.thegostsniperfr.android_basic_navigation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import fr.thegostsniperfr.android_basic_navigation.PreferencesManager


@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }
    val data = remember { mutableStateOf(preferencesManager.getData("myKey", "")) }

    Box(
        Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

                value = data.value,
                onValueChange = {
                    data.value = it
                    preferencesManager.saveData("myKey", it)
                },

                placeholder = {
                    Text(text = "Enter your value to save.")
                },

                singleLine = true,
            )
        }
    }
}
