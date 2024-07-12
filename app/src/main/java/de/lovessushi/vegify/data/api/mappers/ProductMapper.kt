package de.lovessushi.vegify.data.api.mappers

import de.lovessushi.vegify.data.api.entities.ProductResponseEntity
import de.lovessushi.vegify.domain.models.Product

fun ProductResponseEntity.mapToModel() = Product(
    code = this.code,
    name = this.product.product_name,
    brand = this.product.brands
)