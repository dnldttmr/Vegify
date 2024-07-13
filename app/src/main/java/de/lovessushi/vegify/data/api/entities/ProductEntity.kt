package de.lovessushi.vegify.data.api.entities

data class ProductEntity(
    val created_t: Int,
    val score: Int,
    val brands: String,
    val categories: String,
    val product_name: String,
    val labels: String,
    val ingredients: List<IngredientsEntity>
)