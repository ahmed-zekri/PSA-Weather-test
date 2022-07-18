package com.example.open_weather_api.domain.use_cases

import com.example.open_weather_api.domain.repositories.WeatherRepository
import javax.inject.Inject

class FetchWeather @Inject constructor(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke(city: String) = weatherRepository.getWeatherDetails(city = city)

}


