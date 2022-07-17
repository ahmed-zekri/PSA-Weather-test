package com.example.open_weather_api.data.dto

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)