package com.example.open_weather_api.data.repositories

import com.example.open_weather_api.data.dto.WeatherDTO
import com.example.open_weather_api.domain.repositories.RemoteWeatherRepository
import com.example.open_weather_api.data.remote.WeatherApi
import javax.inject.Inject

class RemoteRemoteWeatherRepositoryImpl @Inject constructor(private val api: WeatherApi) : RemoteWeatherRepository {
    override suspend fun getWeatherDetailsByCityName(city: String): WeatherDTO =
        api.getWeatherDetailsByCityName(city)

    override suspend fun getWeatherDetailsByCoordinates(lat: Double, lon: Double): WeatherDTO =
        api.getWeatherDetailsByCoordinates(lat,lon)


}