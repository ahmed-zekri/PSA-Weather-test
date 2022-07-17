package com.example.open_weather_api.data.di

import com.example.open_weather_api.data.repositories.WeatherRepositoryImpl
import com.example.open_weather_api.domain.repositories.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun providesWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl): WeatherRepository
}