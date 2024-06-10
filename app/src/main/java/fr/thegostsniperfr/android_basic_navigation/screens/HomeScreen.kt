package fr.thegostsniperfr.android_basic_navigation.screens

import android.graphics.drawable.Icon
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.thegostsniperfr.android_basic_navigation.db.UsersModel
import fr.thegostsniperfr.android_basic_navigation.db.UsersModelViewModel
import java.io.Console


@Composable
fun HomeScreen(
    vm: UsersModelViewModel
) {
    val context = LocalContext.current
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
            ) {
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Name") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                )

                TextField(
                    value = surname,
                    onValueChange = { surname = it },
                    label = { Text("Surname") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                )
            }

            Button(
                onClick = {
                    if(!name.equals("") && !surname.equals("")) {
                        vm.addUser(name, surname)
                    } else {
                        Toast.makeText(context, "Invalid name or surname!", Toast.LENGTH_LONG).show()
                    }

                    name = ""
                    surname = ""
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Add User")
            }

            val usersList by vm.getAllUsers().collectAsState(initial = emptyList())

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(usersList) { user ->
                    UserInfo(user, vm)
                }
            }
        }
    }
}

@Composable
fun UserInfo(
    user: UsersModel,
    vm: UsersModelViewModel
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = user.name)
        Text(text = user.surname)
        IconButton(
            onClick = {
                println("Delete pressed")
                vm.deleteUser(user)
            },
        ) {
            Icon(
                Icons.Filled.Clear,
                contentDescription = "DeleteUser",
                tint = Color.Red
            )
        }
    }
}
