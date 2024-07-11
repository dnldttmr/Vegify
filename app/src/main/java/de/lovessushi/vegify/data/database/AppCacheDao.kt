package de.lovessushi.vegify.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AppCacheDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(appCache: AppCache)

    @Query("DELETE FROM app_cache WHERE id = :id")
    suspend fun delete(id: String)

    @Query("SELECT * FROM app_cache WHERE id = :id")
    suspend fun get(id: String): AppCache?
}