package com.example.open_weather_api.data.di

import com.example.open_weather_api.domain.repositories.RemoteWeatherRepository
import com.example.open_weather_api.domain.use_cases.FetchWeather
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun providesUseCase(remoteWeatherRepository: RemoteWeatherRepository): FetchWeather =
        FetchWeather(remoteWeatherRepository)
}