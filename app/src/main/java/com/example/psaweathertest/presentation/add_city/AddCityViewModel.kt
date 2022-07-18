package com.example.psaweathertest.presentation.add_city

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.psaweathertest.common.Resources
import com.example.psaweathertest.domain.use_case.FindAndUpdateWeatherByCityName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AddCityViewModel @Inject constructor(private val findAndUpdateWeatherByCityName: FindAndUpdateWeatherByCityName) :
    ViewModel() {
    val cityName = mutableStateOf("")
    private val _cityWeatherState = mutableStateOf(CityWeatherState())
    val cityWeatherState: State<CityWeatherState> = _cityWeatherState
    fun searchAndSaveCity() = findAndUpdateWeatherByCityName(cityName.value).onEach {

        when (it) {

            is Resources.Error -> _cityWeatherState.value = CityWeatherState(error = it.message)
            is Resources.Success -> _cityWeatherState.value =
                CityWeatherState(weatherData = it.data)
            is Resources.Loading -> _cityWeatherState.value = CityWeatherState(loading = true)

        }

    }.launchIn(viewModelScope)


}