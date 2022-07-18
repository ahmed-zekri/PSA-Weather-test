package com.example.psaweathertest.domain.repositories

import com.example.psaweathertest.domain.model.Weather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getAllWeatherData(): Flow<List<Weather>>
    suspend fun insertWeatherData(weather: Weather)
    suspend fun findWeatherDataByCityName(cityName: String): Weather?
}