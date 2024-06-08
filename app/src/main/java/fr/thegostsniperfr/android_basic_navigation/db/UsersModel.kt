package fr.thegostsniperfr.android_basic_navigation.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UsersModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val surname: String
)