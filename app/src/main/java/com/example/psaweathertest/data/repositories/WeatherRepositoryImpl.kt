package com.example.psaweathertest.data.repositories

import com.example.open_weather_api.domain.use_cases.FetchWeather
import com.example.psaweathertest.common.ErrorHandler
import com.example.psaweathertest.common.Resources
import com.example.psaweathertest.common.toWeather
import com.example.psaweathertest.data.data_source.WeatherDao
import com.example.psaweathertest.domain.model.Weather
import com.example.psaweathertest.domain.repositories.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val fetchWeather: FetchWeather,
    private val dao: WeatherDao, val errorHandler: ErrorHandler
) : WeatherRepository {
    override fun getAllWeatherData(): Flow<List<Weather>> = dao.getData()

    override suspend fun insertWeatherData(weather: Weather) = dao.insertData(weather)

    override fun synchronizeDatabaseWithRemoteServer(cityName: String) = flow {
        var error = ""
        emit(Resources.Loading())

        try {


            val weather = fetchWeather(cityName)
            weather?.apply {

                dao.insertData(toWeather())
                emit(Resources.Success(toWeather()))
            }
        } catch (e: Exception) {

            error = errorHandler.handleException(exception = e)

        }
        if (error.isNotBlank())
            emit(Resources.Success(dao.getDataByCityName(cityName), warning = error))

    }

}