package de.lovessushi.vegify.data.database

import java.util.Date
import java.util.concurrent.TimeUnit

class AppCacheManager(private val appCacheDao: AppCacheDao) {

    suspend fun insert(id: String, data: String) {
        val appCache = AppCache(id, data, Date())
        appCacheDao.insert(appCache)
    }

    suspend fun delete(id: String) {
        appCacheDao.delete(id)
    }

    suspend fun get(id: String): String? {
        val appCache = appCacheDao.get(id)

        return if (appCache != null && !isCacheExpired(appCache.timestamp))
            appCache.data
        else null
    }

    private fun isCacheExpired(timestamp: Date): Boolean {
        val currentTime = Date()
        val diff = currentTime.time - timestamp.time
        val diffDays = TimeUnit.MILLISECONDS.toDays(diff)
        //TODO: Rework Cache using variable caching TimeUnit
        //Right now cache is alive for 5 days
        return diffDays > 5
    }
}