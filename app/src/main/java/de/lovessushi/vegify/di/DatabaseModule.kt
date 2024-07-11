package de.lovessushi.vegify.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import de.lovessushi.vegify.data.database.AppCacheManager
import de.lovessushi.vegify.data.database.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppCacheManager(@ApplicationContext context: Context) =
        AppCacheManager(
            Room.databaseBuilder(
                context,
                AppDatabase::class.java, "app_database"
            ).build().appCacheDao()
        )
}