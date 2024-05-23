package de.lovessushi.vegify.domain.usecases

import de.lovessushi.vegify.data.repositories.OpenFoodFactRepository

class GetFoodFactWithBarcodeUseCase(
    private val openFoodFactRepository: OpenFoodFactRepository
) {

    suspend fun execute(foodName: String): String {
        return openFoodFactRepository.getFoodFactWithBarcode(foodName)
    }
}