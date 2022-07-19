package com.example.open_weather_api.domain.use_cases

import androidx.core.text.isDigitsOnly
import com.example.open_weather_api.domain.repositories.RemoteWeatherRepository
import javax.inject.Inject

enum class FetchingMethod {

    BY_COORDINATES, BY_NAME

}

class FetchWeather @Inject constructor(val remoteWeatherRepository: RemoteWeatherRepository) {

    /**
     *Return the weather details of the given city , the input can be either the city name as a String or the the geographic coordinates as a pair of doubles
     *
     *@param data : A string representing the city name must be provided if the fetchingMethod enum value provided is BY_NAME, otherwise , a pair of doubles must be provided, providing the wrong input will lead to an IllegalStateException
     * @param fetchingMethod : BY_COORDINATES or BY_NAMES should be provided. if not provided , BY_NAMES will be taken by default
     */

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


