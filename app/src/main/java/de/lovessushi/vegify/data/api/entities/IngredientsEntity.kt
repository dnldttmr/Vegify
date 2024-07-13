package de.lovessushi.vegify.data.api.entities

data class IngredientsEntity(
    val text: String,
    val vegan: String?,
    val vegeterian: String?,
    val ingredients: List<IngredientsEntity>?
)