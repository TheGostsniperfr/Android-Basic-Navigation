package fr.thegostsniperfr.android_basic_navigation.db

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class UsersModelViewModel(
    private val dao: UsersModelDao
): ViewModel() {
    fun addUser(name: String, surname: String) {
        viewModelScope.launch{
            dao.addUser(usersModel =  UsersModel(name = name, surname = surname))
        }
    }

    fun deleteUser(user: UsersModel) {
        viewModelScope.launch{
            dao.deleteUser(user = user)
        }
    }

    fun getAllUsers(): Flow<List<UsersModel>> {
        return dao.getAllUsers()
    }
}