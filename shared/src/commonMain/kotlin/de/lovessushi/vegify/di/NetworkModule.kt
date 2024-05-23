package de.lovessushi.vegify.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkModule = module {
    singleOf<HttpClient> {
        HttpClient {
            install(HttpTimeout) {
                socketTimeoutMillis = 30000
                requestTimeoutMillis = 30000
            }
            defaultRequest {
                header("Content-Type", "application/json")
                url("https://world.openfoodfacts.org/api/")
            }
        }
    }
}