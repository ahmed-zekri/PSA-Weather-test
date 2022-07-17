package com.example.open_weather_api.domain.repositories

import com.example.open_weather_api.data.WeatherDTO

interface WeatherRepository {
    suspend fun getWeatherDetails(lat: String, lon: String): WeatherDTO

}