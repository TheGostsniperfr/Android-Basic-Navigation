package fr.thegostsniperfr.android_basic_navigation.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersModelDao {
    @Query("Select * from usersmodel")
    fun getAllUsers(): Flow<List<UsersModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(usersModel: UsersModel) // Suspend is to run in asynchronous

    @Delete
    suspend fun deleteUser(user: UsersModel)
}