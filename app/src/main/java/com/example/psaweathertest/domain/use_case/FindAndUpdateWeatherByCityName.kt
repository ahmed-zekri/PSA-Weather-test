package com.example.psaweathertest.domain.use_case

import com.example.psaweathertest.common.ErrorHandler
import com.example.psaweathertest.common.Resources
import com.example.psaweathertest.domain.model.Weather
import com.example.psaweathertest.domain.repositories.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FindAndUpdateWeatherByCityName @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val errorHandler: ErrorHandler
) {
    operator fun invoke(city: String): Flow<Resources<Weather>> =
        weatherRepository.synchronizeDatabaseWithRemoteServer(city)


}