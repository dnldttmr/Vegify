package de.lovessushi.vegify.domain.models

data class Product(
    val code: String,
    val name: String,
    val brand: String,
    val isVegan: Boolean,
    val isVegetarian: Boolean,
    val ingredients: List<Ingredient>
) {

    data class Ingredient(
        val name: String,
        val isVegan: Boolean?,
        val isVegetarian: Boolean?,
        val ingredients: List<Ingredient>?
    )
}