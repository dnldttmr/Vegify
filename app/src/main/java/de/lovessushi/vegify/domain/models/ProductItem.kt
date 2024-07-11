package de.lovessushi.vegify.domain.models

data class ProductItem(
    val code: String,
    val product: Product
) {

    data class Product(
        val created_t: Int,
        val score: Int
    )
}