package com.example.psaweathertest.presentation.add_city

import com.example.psaweathertest.domain.model.Weather

data class CityWeatherState(
    val loading: Boolean = false,
    val weatherData: Weather? = null,
    val error: String = ""

)
