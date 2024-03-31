package com.example.radiostationshowcase.di

import com.example.radiostationshowcase.data.repository.RadioStationRepositoryImpl
import com.example.radiostationshowcase.domain.repository.RadioStationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRadioStationRepository(): RadioStationRepository {
        return RadioStationRepositoryImpl()
    }
}