package com.example.psaweathertest.domain.use_case

import com.example.psaweathertest.common.ErrorHandler
import com.example.psaweathertest.common.Resources
import com.example.psaweathertest.domain.repositories.WeatherRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FindAndUpdateWeatherByCityName @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val errorHandler: ErrorHandler
) {
    operator fun invoke(city: String) = flow {

        emit(Resources.Loading())
        try {
            val weatherDetail = weatherRepository.synchronizeDatabaseWithRemoteServer(city)
            emit(Resources.Success(weatherDetail))
        } catch (e: Exception) {
            emit(Resources.Error(errorHandler.handleException(e)))


        }
    }


}