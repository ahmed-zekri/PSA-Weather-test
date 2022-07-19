package com.example.psaweathertest.presentation.city_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.psaweathertest.common.CITY_PARAM
import com.example.psaweathertest.common.Resources
import com.example.psaweathertest.domain.model.Weather
import com.example.psaweathertest.domain.use_case.FindAndUpdateWeatherByCityName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CityDetailsViewModel @Inject constructor(
    findAndUpdateWeatherByCityName: FindAndUpdateWeatherByCityName,
    savedStateHandle: SavedStateHandle

) : ViewModel() {
    private val _weatherDetails = mutableStateOf<Weather?>(null)
    val weatherDetails: State<Weather?> = _weatherDetails

    init {
        savedStateHandle.get<String>(CITY_PARAM)?.let {


            findAndUpdateWeatherByCityName(it).onEach { weather ->
                when (weather) {
                    is Resources.Success -> _weatherDetails.value = weather.data


                    else -> {}
                }


            }.launchIn(viewModelScope)


        }
    }
}