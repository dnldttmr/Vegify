package de.lovessushi.vegify.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.lovessushi.vegify.data.repositories.SampleRepository
import de.lovessushi.vegify.data.repositories.SampleRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun provideSampleRepository(impl: SampleRepositoryImpl): SampleRepository
}