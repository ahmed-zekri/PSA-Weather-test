package com.example.psaweathertest.presentation

sealed class Screen(val route: String) {
    object CitiesList : Screen(route = "citiesList")
    object AddCity : Screen(route = "addCity")
    data class CityWeather(val city: String) : Screen(route = "cityWeather/$city")
}