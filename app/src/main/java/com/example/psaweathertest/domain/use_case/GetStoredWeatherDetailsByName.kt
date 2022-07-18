package com.example.psaweathertest.domain.use_case

import com.example.psaweathertest.domain.repositories.WeatherRepository
import javax.inject.Inject

class GetStoredWeatherDetailsByName @Inject constructor(
    private val weatherRepository: WeatherRepository,

    ) {
    suspend operator fun invoke(cityName: String) =
        weatherRepository.getLocalWeatherDataByCityName(cityName)

}


