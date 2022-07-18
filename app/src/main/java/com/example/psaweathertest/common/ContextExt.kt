package com.example.psaweathertest.common

import android.content.Context
import com.example.open_weather_api.data.dto.WeatherDTO
import com.example.psaweathertest.domain.model.Weather

fun Context.getImageIdByName(imageName: String) =
    resources.getIdentifier(imageName, "drawable", packageName)

