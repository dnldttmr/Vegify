package de.lovessushi.vegify.android.di

import de.lovessushi.vegify.domain.usecases.GetFoodFactWithBarcodeUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val androidModule = module {
    singleOf(::GetFoodFactWithBarcodeUseCase)
}