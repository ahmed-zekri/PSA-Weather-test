package com.example.open_weather_api.domain.repositories

import com.example.open_weather_api.data.dto.WeatherDTO

interface RemoteWeatherRepository {
    suspend fun getWeatherDetails(city: String): WeatherDTO?

}