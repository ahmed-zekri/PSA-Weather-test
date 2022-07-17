package com.example.open_weather_api.data.repositories

import com.example.open_weather_api.data.dto.WeatherDTO
import com.example.open_weather_api.domain.repositories.WeatherRepository
import com.example.open_weather_api.data.remote.WeatherApi
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val api: WeatherApi) : WeatherRepository {
    override suspend fun getWeatherDetails(city: String): WeatherDTO =
        api.getWeatherDetails(city)

}