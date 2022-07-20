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
class CitiesListViewModel @Inject constructor(val getAllStoredWeatherDetails: GetAllStoredWeatherDetails) :
    ViewModel() {

    private val _citiesWeatherListState = mutableStateOf(listOf<Weather>())
    val citiesWeatherListState: State<List<Weather>> = _citiesWeatherListState

    private val _citiesWeatherListOrderTypeState =
        mutableStateOf<CitiesWeatherDetailsOrderType>(CitiesWeatherDetailsOrderType.Ascending)


    private val _citiesWeatherListOrderState =
        mutableStateOf<CitiesWeatherDetailsOrder>(
            CitiesWeatherDetailsOrder.CityName(
                CitiesWeatherDetailsOrderType.Ascending
            )
        )


    val citiesWeatherList: State<List<Weather>> = _citiesWeatherListState

    init {
        getList()

    }

    fun getList() {
        getAllStoredWeatherDetails(
            if (_citiesWeatherListOrderState.value is CitiesWeatherDetailsOrder.CityName)
                CitiesWeatherDetailsOrder.CityName(_citiesWeatherListOrderTypeState.value)
            else
                CitiesWeatherDetailsOrder.Temp(_citiesWeatherListOrderTypeState.value)


        ).onEach { result ->

            _citiesWeatherListState.value = result
        }.launchIn(viewModelScope)

    }

    fun updateOrderTypeState(orderType: CitiesWeatherDetailsOrderType) {

        _citiesWeatherListOrderTypeState.value = orderType

    }

    fun updateOrderState(orderType: CitiesWeatherDetailsOrder) {

        _citiesWeatherListOrderState.value = orderType

    }

}