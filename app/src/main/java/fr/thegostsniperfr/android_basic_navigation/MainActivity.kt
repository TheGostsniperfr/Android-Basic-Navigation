package fr.thegostsniperfr.android_basic_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import fr.thegostsniperfr.android_basic_navigation.db.UsersModelDatabase
import fr.thegostsniperfr.android_basic_navigation.db.UsersModelViewModel
import fr.thegostsniperfr.android_basic_navigation.screens.HomeScreen
import fr.thegostsniperfr.android_basic_navigation.ui.theme.Android_Basic_Navigation_Theme

class MainActivity : ComponentActivity() {

    private val db by lazy {
        Room.databaseBuilder(
            context = applicationContext,
            klass = UsersModelDatabase::class.java,
            name = "usersmodel.db"
        ).build()
    }

    private val viewModel by viewModels<UsersModelViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return UsersModelViewModel(db.dao) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_Basic_Navigation_Theme {
                HomeScreen(vm = viewModel)
            }
        }
    }
}

