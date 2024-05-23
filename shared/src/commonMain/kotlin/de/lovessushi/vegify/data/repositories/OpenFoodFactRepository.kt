package de.lovessushi.vegify.data.repositories

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class OpenFoodFactRepository(private val httpClient: HttpClient) {

    suspend fun getFoodFactWithBarcode(barcode: String): String {
        val response = httpClient.get("v0/product/$barcode.json")
        return response.bodyAsText()
    }
}