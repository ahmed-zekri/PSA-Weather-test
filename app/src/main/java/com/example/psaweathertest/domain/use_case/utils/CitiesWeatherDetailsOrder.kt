package com.example.psaweathertest.domain.use_case.utils

sealed class CitiesWeatherDetailsOrder(val orderType: CitiesWeatherDetailsOrderType) {
    class CityName(orderType: CitiesWeatherDetailsOrderType = CitiesWeatherDetailsOrderType.Ascending) :
        CitiesWeatherDetailsOrder(orderType)

    class Temp(orderType: CitiesWeatherDetailsOrderType = CitiesWeatherDetailsOrderType.Ascending) :
        CitiesWeatherDetailsOrder(orderType)

    class Humidity(orderType: CitiesWeatherDetailsOrderType = CitiesWeatherDetailsOrderType.Ascending) :
        CitiesWeatherDetailsOrder(orderType)


}
