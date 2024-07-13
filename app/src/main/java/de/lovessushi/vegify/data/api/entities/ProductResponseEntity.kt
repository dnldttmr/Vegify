package de.lovessushi.vegify.data.api.entities

data class ProductResponseEntity(
    val code: String,
    val status: Int,
    val product: ProductEntity
)