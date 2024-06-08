package fr.thegostsniperfr.android_basic_navigation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.thegostsniperfr.android_basic_navigation.db.UsersModelViewModel


@Composable
fun HomeScreen(
    vm: UsersModelViewModel
) {
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
                    vm.addUser(name, surname)
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
                    UserInfo(user.name, user.surname)
                }
            }
        }
    }
}

@Composable
fun UserInfo(name: String, surname: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = name)
        Text(text = surname)
    }
}
