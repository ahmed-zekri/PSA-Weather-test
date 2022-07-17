package com.example.open_weather_api.remote


import com.example.open_weather_api.common.API_KEY
import com.example.open_weather_api.data.WeatherDTO
import retrofit2.http.GET

import retrofit2.http.Query

interface WeatherApi {


    @GET("/")
    suspend fun getWeatherDetails(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("exclude") exclude: String,
        @Query("appid") appid: String = API_KEY.ifBlank { throw IllegalStateException("") }

    ): WeatherDTO


}