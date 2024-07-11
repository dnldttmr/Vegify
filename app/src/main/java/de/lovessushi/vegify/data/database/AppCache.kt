package de.lovessushi.vegify.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "app_cache")
data class AppCache(
    @PrimaryKey val id: String,
    val data: String,
    val timestamp: Date
)