package com.example.psaweathertest.presentation.city_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.psaweathertest.common.CITY_PARAM
import com.example.psaweathertest.domain.model.Weather
import com.example.psaweathertest.domain.use_case.GetStoredWeatherDetailsByName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityDetailsViewModel @Inject constructor(
    getStoredWeatherDetailsByName: GetStoredWeatherDetailsByName,
    savedStateHandle: SavedStateHandle

) : ViewModel() {
    private val _weatherDetails = mutableStateOf<Weather?>(null)
    val weatherDetails: State<Weather?> = _weatherDetails

    init {
        savedStateHandle.get<String>(CITY_PARAM)?.let {

            viewModelScope.launch {

                _weatherDetails.value = getStoredWeatherDetailsByName(it)

            }
        }
    }
}