package com.example.psaweathertest.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Weather(
    val city: String,
    val main: String,
    val description: String,
    val icon: String,
    val temp: Int,
    val temp_min: Int,
    val temp_max: Int,
    val pressure: Int,
    val humidity: Int,
    val windSpeed: Int,
    val windDegree: Int,
    @PrimaryKey val id: Int? = null
)