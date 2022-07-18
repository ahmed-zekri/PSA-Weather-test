package com.example.psaweathertest.domain.use_case

import com.example.psaweathertest.domain.repositories.WeatherRepository
import com.example.psaweathertest.domain.use_case.utils.CitiesWeatherDetailsOrder
import com.example.psaweathertest.domain.use_case.utils.CitiesWeatherDetailsOrderType
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAllStoredWeatherDetails @Inject constructor(
    private val weatherRepository: WeatherRepository,

    ) {
    operator fun invoke(order: CitiesWeatherDetailsOrder) =
        weatherRepository.getAllWeatherData().map { citiesWeatherDetails ->
            when (order.orderType) {

                is CitiesWeatherDetailsOrderType.Ascending -> {
                    when (order) {

                        is CitiesWeatherDetailsOrder.CityName -> citiesWeatherDetails.sortedBy { it.city }
                        is CitiesWeatherDetailsOrder.Humidity -> citiesWeatherDetails.sortedBy { it.humidity }
                        is CitiesWeatherDetailsOrder.Temp -> citiesWeatherDetails.sortedBy { it.temp }
                    }


                }
                CitiesWeatherDetailsOrderType.Descending -> when (order) {

                    is CitiesWeatherDetailsOrder.CityName -> citiesWeatherDetails.sortedByDescending { it.city }
                    is CitiesWeatherDetailsOrder.Humidity -> citiesWeatherDetails.sortedByDescending { it.humidity }
                    is CitiesWeatherDetailsOrder.Temp -> citiesWeatherDetails.sortedByDescending { it.temp }
                }

            }


        }
}


