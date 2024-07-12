package de.lovessushi.vegify.data.repositories

import com.google.gson.Gson
import de.lovessushi.vegify.data.api.OpenFoodFactsApi
import de.lovessushi.vegify.data.api.mappers.mapToModel
import de.lovessushi.vegify.data.database.AppCacheManager
import de.lovessushi.vegify.data.exceptions.ProductNotFoundException
import de.lovessushi.vegify.domain.models.Product
import javax.inject.Inject

//region Interface
interface ProductRepository {

    suspend fun getProduct(code: String): Product?
}
//endregion

class ProductRepositoryImpl @Inject constructor(
    private val openFoodFactsApi: OpenFoodFactsApi,
    private val appCacheManager: AppCacheManager
) : ProductRepository {

    override suspend fun getProduct(code: String): Product? {
        val product = if (appCacheManager.get(code) != null) {
            Gson().fromJson(appCacheManager.get(code), Product::class.java)
        } else {
            val response = openFoodFactsApi.getProduct(code)

            when (response.status) {
                STATUS_CODE_PRODUCT_FOUND -> {
                    val product = response.mapToModel()
                    appCacheManager.insert(code, Gson().toJson(product))
                    product
                }

                else -> throw ProductNotFoundException(code)
            }
        }

        return product
    }

    companion object {

        private const val STATUS_CODE_PRODUCT_FOUND = 1
    }
}