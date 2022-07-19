package com.example.open_weather_api.domain.use_cases

import androidx.core.text.isDigitsOnly
import com.example.open_weather_api.domain.repositories.RemoteWeatherRepository
import javax.inject.Inject

enum class FetchingMethod {

    BY_COORDINATES, BY_NAME

}

class FetchWeather @Inject constructor(val remoteWeatherRepository: RemoteWeatherRepository) {

    suspend inline operator fun invoke(
        data: Any,
        fetchingMethod: FetchingMethod = FetchingMethod.BY_NAME
    ) =
        when (fetchingMethod) {
            FetchingMethod.BY_NAME -> if (data is String) {
                if (data.isBlank())
                    throw IllegalStateException("Empty city name provided")
                remoteWeatherRepository.getWeatherDetailsByCityName(data)

            } else throw IllegalStateException("Invalid type provided")


            FetchingMethod.BY_COORDINATES -> if (data is Pair<*, *> && data.first is Double && data.second is Double) {

                remoteWeatherRepository.getWeatherDetailsByCoordinates(
                    data.first as Double,
                    data.second as Double
                )
            } else throw IllegalStateException("Invalid type provided")

        }


}


