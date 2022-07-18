package com.example.psaweathertest.data.di

import com.example.psaweathertest.common.ErrorHandler
import com.example.psaweathertest.domain.repositories.WeatherRepository
import com.example.psaweathertest.domain.use_case.FindAndUpdateWeatherByCityName
import com.example.psaweathertest.domain.use_case.GetAllStoredWeatherDetails
import com.example.psaweathertest.domain.use_case.GetStoredWeatherDetailsByName
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
    fun providesGetAllStoredWeatherDetails(
        weatherRepository: WeatherRepository,

        ): GetAllStoredWeatherDetails =
        GetAllStoredWeatherDetails(weatherRepository)

    @Provides
    @Singleton
    fun providesGetStoredWeatherDetailsByName(
        weatherRepository: WeatherRepository,

        ): GetStoredWeatherDetailsByName =
        GetStoredWeatherDetailsByName(weatherRepository)


}