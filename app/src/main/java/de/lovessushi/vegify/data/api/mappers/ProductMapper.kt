package de.lovessushi.vegify.data.api.mappers

import de.lovessushi.vegify.data.api.entities.IngredientsEntity
import de.lovessushi.vegify.data.api.entities.ProductResponseEntity
import de.lovessushi.vegify.domain.models.Product

fun ProductResponseEntity.mapToModel() =
    Product(
        code = this.code,
        name = this.product.product_name,
        brand = this.product.brands,
        isVegan = this.product.labels.contains("vegan", true),
        isVegetarian = this.product.labels.contains("vegan", true) ||
                this.product.labels.contains("vegetarisch", true),
        ingredients = this.product.ingredients.map { it.mapToModel() }
    )

fun IngredientsEntity.mapToModel(): Product.Ingredient {
    return Product.Ingredient(
        name = this.text,
        isVegan = this.vegan?.toBoolean(),
        isVegetarian = this.vegeterian?.toBoolean(),
        ingredients = this.ingredients?.map { it.mapToModel() }
    )
}

fun String?.toBoolean() = this?.lowercase().equals("yes")