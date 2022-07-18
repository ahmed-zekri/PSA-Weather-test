package com.example.psaweathertest.presentation.add_city

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.psaweathertest.common.Resources
import com.example.psaweathertest.domain.repositories.WeatherRepository
import com.example.psaweathertest.use_case.FindAndUpdateWeatherByCityName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AddCityViewModel @Inject constructor(private val findAndUpdateWeatherByCityName: FindAndUpdateWeatherByCityName) :
    ViewModel() {
    var cityName = mutableStateOf("")

    fun searchCity() = findAndUpdateWeatherByCityName(cityName.value).onEach {

        when (it) {

            is Resources.Error -> println(it.message)

        }

    }.launchIn(viewModelScope)


}