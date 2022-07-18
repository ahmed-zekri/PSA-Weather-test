package com.example.psaweathertest.domain.use_case.utils

sealed class CitiesWeatherDetailsOrder(val orderType: CitiesWeatherDetailsOrderType) {
    class CityName(orderType: CitiesWeatherDetailsOrderType) : CitiesWeatherDetailsOrder(orderType)
    class Temp(orderType: CitiesWeatherDetailsOrderType) : CitiesWeatherDetailsOrder(orderType)
    class Humidity(orderType: CitiesWeatherDetailsOrderType) : CitiesWeatherDetailsOrder(orderType)


}
