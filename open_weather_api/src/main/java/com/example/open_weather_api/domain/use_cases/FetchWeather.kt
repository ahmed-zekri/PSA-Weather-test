package com.example.open_weather_api.domain.use_cases

import com.example.open_weather_api.domain.repositories.RemoteWeatherRepository
import javax.inject.Inject

class FetchWeather @Inject constructor(private val remoteWeatherRepository: RemoteWeatherRepository) {

    suspend operator fun invoke(city: String) = remoteWeatherRepository.getWeatherDetails(city = city)

}


