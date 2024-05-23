package de.lovessushi.vegify.di

import de.lovessushi.vegify.data.repositories.FoodFactRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::FoodFactRepository)
}