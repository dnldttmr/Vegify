package de.lovessushi.vegify.data.repositories

import de.lovessushi.vegify.data.api.AppApi
import de.lovessushi.vegify.data.database.AppCacheManager
import javax.inject.Inject

interface SampleRepository {
    suspend fun getSample(): String
}

class SampleRepositoryImpl @Inject constructor(
    private val appApi: AppApi,
    private val appCacheManager: AppCacheManager
) : SampleRepository {

    override suspend fun getSample(): String {
        return "Cock"
    }
}