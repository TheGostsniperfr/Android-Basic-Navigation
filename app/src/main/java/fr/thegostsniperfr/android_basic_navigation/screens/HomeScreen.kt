package fr.thegostsniperfr.android_basic_navigation.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import fr.thegostsniperfr.android_basic_navigation.Screen


@Composable
fun HomeScreen(
    navController: NavController,
) {
   Box(
       modifier = Modifier
           .fillMaxSize()
           .background(color = Color.Black),

       contentAlignment = Alignment.Center
   ) {
        Text(
            modifier = Modifier.clickable {
                navController.navigate(Screen.Hello.route)
            },

            text = "Go to Hello screen !",
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontWeight = FontWeight.Bold
        )
   }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen(
        navController = rememberNavController()
    )
}