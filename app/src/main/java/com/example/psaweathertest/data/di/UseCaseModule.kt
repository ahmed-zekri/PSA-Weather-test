package com.example.psaweathertest.data.di

import com.example.psaweathertest.common.ErrorHandler
import com.example.psaweathertest.domain.repositories.WeatherRepository
import com.example.psaweathertest.domain.use_case.FindAndUpdateWeatherByCityName
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


}