package com.example.psaweathertest.domain.model

import androidx.room.Entity

@Entity
data class Weather(val main: String, val description: String, val icon: String)
