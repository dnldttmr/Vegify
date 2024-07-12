package de.lovessushi.vegify.data.api.entities

data class ProductResponseEntity(
    val code: String,
    val status: Int,
    val product: ProductEntity
) {

    data class ProductEntity(
        val created_t: Int,
        val score: Int,
        val brands: String,
        val categories: String,
        val product_name: String
    )
}