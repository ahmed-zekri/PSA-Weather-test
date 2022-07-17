package com.example.open_weather_api.data

data class WeatherDTO(
    val current: Current,
    val lat: Double,
    val lon: Double,
    val minutely: List<Minutely>,
    val timezone: String,
    val timezone_offset: Int
)