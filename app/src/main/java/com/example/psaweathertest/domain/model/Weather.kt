package com.example.psaweathertest.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Weather(
    @PrimaryKey val city: String,
    val main: String,
    val description: String,
    val icon: String,
    val temp: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Int,
    val humidity: Int,
    val windSpeed: Double,
    val windDegree: Int

)