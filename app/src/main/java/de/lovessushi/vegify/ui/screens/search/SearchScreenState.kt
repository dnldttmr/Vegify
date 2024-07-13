package de.lovessushi.vegify.ui.screens.search

import de.lovessushi.vegify.domain.models.Product

data class SearchScreenState(
    val product: Product? = null,
    val error: Exception? = null
)