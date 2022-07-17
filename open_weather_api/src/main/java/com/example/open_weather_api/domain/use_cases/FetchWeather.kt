package com.example.open_weather_api.domain.use_cases

import com.example.open_weather_api.common.APIResult
import com.example.open_weather_api.domain.repositories.WeatherRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchWeather @Inject constructor(private val weatherRepository: WeatherRepository) {

    operator fun invoke(lat: String, lon: String) = flow {
        emit(APIResult.Loading())

        try {
            val weatherDetails = weatherRepository.getWeatherDetails(lat = lat, lon = lon)

            emit(APIResult.Success(weatherDetails))
        } catch (exception: Exception) {
            emit(APIResult.Error(exception.message ?: ""))
        }


    }


}