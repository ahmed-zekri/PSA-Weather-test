package com.example.psaweathertest.presentation.cities_list

import com.example.psaweathertest.domain.model.Weather

data class CitiesWeatherListState(
    val isLoading: Boolean = false,
    val cities: List<Weather>? = null,
    val error: String = ""
)