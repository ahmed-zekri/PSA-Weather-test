package com.example.open_weather_api.data.repositories

import com.example.open_weather_api.data.WeatherDTO
import com.example.open_weather_api.domain.repositories.WeatherRepository
import com.example.open_weather_api.remote.WeatherApi

class WeatherRepositoryImpl constructor(private val api: WeatherApi) : WeatherRepository {
    override suspend fun getWeatherDetails(lat: String, lon: String): WeatherDTO =api.getWeatherDetails(lat,lon)

}