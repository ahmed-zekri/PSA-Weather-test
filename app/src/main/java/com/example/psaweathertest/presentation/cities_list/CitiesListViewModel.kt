package com.example.psaweathertest.presentation.cities_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.psaweathertest.common.Resources
import com.example.psaweathertest.domain.model.Weather
import com.example.psaweathertest.domain.use_case.GetAllStoredWeatherDetails
import com.example.psaweathertest.domain.use_case.utils.CitiesWeatherDetailsOrder
import com.example.psaweathertest.domain.use_case.utils.CitiesWeatherDetailsOrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CitiesListViewModel @Inject constructor(getAllStoredWeatherDetails: GetAllStoredWeatherDetails) :
    ViewModel() {

    private val _citiesWeatherListState = mutableStateOf(listOf<Weather>())
    val citiesWeatherList: State<List<Weather>> = _citiesWeatherListState

    init {
        getAllStoredWeatherDetails(CitiesWeatherDetailsOrder.CityName(CitiesWeatherDetailsOrderType.Ascending)).onEach { result ->

            _citiesWeatherListState.value = result
        }.launchIn(viewModelScope)

    }


}