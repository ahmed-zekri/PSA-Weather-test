package com.example.psaweathertest.data.di

import com.example.open_weather_api.domain.repositories.RemoteWeatherRepository
import com.example.open_weather_api.domain.use_cases.FetchWeather
import com.example.psaweathertest.common.ErrorHandler
import com.example.psaweathertest.domain.repositories.WeatherRepository
import com.example.psaweathertest.use_case.FindAndUpdateWeatherByCityName
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
    fun providesFindAndUpdateUseCase(
        weatherRepository: WeatherRepository,
        errorHandler: ErrorHandler
    ): FindAndUpdateWeatherByCityName =
        FindAndUpdateWeatherByCityName(weatherRepository, errorHandler)

    @Provides
    @Singleton
    fun providesFetchWeather(
        remoteWeatherRepository:
        RemoteWeatherRepository
    ): FetchWeather =
        FetchWeather(remoteWeatherRepository = remoteWeatherRepository)

}