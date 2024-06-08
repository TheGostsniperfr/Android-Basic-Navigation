package fr.thegostsniperfr.android_basic_navigation.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UsersModel::class], version = 1)
abstract class UsersModelDatabase: RoomDatabase() {
    abstract val dao: UsersModelDao
}