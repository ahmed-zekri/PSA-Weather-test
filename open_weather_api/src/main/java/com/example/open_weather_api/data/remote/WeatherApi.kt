package com.example.open_weather_api.data.remote


import com.example.open_weather_api.common.API_KEY
import com.example.open_weather_api.data.dto.WeatherDTO
import retrofit2.http.GET

import retrofit2.http.Query

interface WeatherApi {


    @GET("/data/2.5/weather?units=metric")
    suspend fun getWeatherDetails(
        @Query("q") city: String,


        @Query("appid") appid: String = API_KEY.ifBlank { throw IllegalStateException("You must provide a valid api key") }

    ): WeatherDTO


}