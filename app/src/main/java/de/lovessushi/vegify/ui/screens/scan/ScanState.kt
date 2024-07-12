package de.lovessushi.vegify.ui.screens.scan

import de.lovessushi.vegify.domain.models.Product

data class ScanState(
    val isLoading: Boolean = false,
    val product: Product? = null,
    val error: Exception? = null
)