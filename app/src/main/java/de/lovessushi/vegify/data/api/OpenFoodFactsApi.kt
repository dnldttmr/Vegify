package de.lovessushi.vegify.data.api

import de.lovessushi.vegify.data.api.entities.ProductResponseEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface OpenFoodFactsApi {

    //TODO: add Response<ProductItem> as return type and handle HTTP Errors
    //https://world.openfoodfacts.org/files/api-documentation.html
    @GET("v0/products/{code}.json")
    suspend fun getProduct(@Path("code") code: String): ProductResponseEntity
}