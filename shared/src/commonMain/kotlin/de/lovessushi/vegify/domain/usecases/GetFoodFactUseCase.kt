package de.lovessushi.vegify.domain.usecases

import de.lovessushi.vegify.data.repositories.FoodFactRepository

class GetFoodFactUseCase(
    private val foodFactRepository: FoodFactRepository
) {

    suspend fun execute(foodName: String): String {
        return foodFactRepository.getFoodFactWithBarcode(foodName)
    }
}