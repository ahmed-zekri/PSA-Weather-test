package com.example.psaweathertest.common

import com.example.open_weather_api.data.dto.WeatherDTO
import com.example.psaweathertest.domain.model.Weather

fun WeatherDTO.toWeather() = Weather(
    city = name,
    main = weather.getOrNull(0)?.main ?: "",
    description = weather.getOrNull(0)?.description ?: "",

    icon = weather.getOrNull(0)?.icon ?: "",
    humidity = main.humidity,
    pressure = main.pressure,
    temp = main.temp,
    windDegree = wind.deg,
    windSpeed = wind.speed, temp_max = main.temp_max,
    temp_min = main.temp_min,
    time = timezone.toDate().toString()

)