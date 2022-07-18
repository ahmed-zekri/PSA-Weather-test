package com.example.psaweathertest.presentation.cities_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.psaweathertest.common.Resources
import com.example.psaweathertest.domain.use_case.GetAllStoredWeatherDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CitiesListViewModel @Inject constructor(getAllStoredWeatherDetails: GetAllStoredWeatherDetails) :
    ViewModel() {

    private val _citiesWeatherListState = mutableStateOf(CitiesWeatherListState(isLoading = true))
    val citiesWeatherListState: State<CitiesWeatherListState> = _citiesWeatherListState

    init {
        getAllStoredWeatherDetails().onEach { result ->




        }.launchIn(viewModelScope)

    }


}