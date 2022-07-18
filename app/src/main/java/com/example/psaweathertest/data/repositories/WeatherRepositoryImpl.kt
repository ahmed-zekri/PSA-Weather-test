package com.example.psaweathertest.data.repositories

import com.example.open_weather_api.domain.use_cases.FetchWeather
import com.example.psaweathertest.common.toWeather
import com.example.psaweathertest.data.data_source.WeatherDao
import com.example.psaweathertest.domain.model.Weather
import com.example.psaweathertest.domain.repositories.WeatherRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    val fetchWeather: FetchWeather,
    val dao: WeatherDao
) : WeatherRepository {
    override fun getAllWeatherData(): Flow<List<Weather>> = dao.getData()

    override suspend fun insertWeatherData(weather: Weather) = dao.insertData(weather)

    override suspend fun findWeatherDataByCityName(cityName: String): Weather? {

        try {
            val weather = fetchWeather(cityName)
            weather?.apply {

                dao.insertData(toWeather())
            }

        } catch (e: Exception) {


        }
        return dao.getDataByCityName(cityName)


    }
}