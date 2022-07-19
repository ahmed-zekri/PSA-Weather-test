package com.example.open_weather_api.domain.use_cases

import com.example.open_weather_api.data.dto.*
import com.example.open_weather_api.domain.repositories.RemoteWeatherRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class FetchWeatherTest {


    private lateinit var remoteWeatherRepository: RemoteWeatherRepository

    private lateinit var fetchWeather: FetchWeather

    private lateinit var fakeDTO: WeatherDTO

    @Before
    fun setUp() {
        remoteWeatherRepository = mock(RemoteWeatherRepository::class.java)
        fetchWeather = FetchWeather(remoteWeatherRepository)
        fakeDTO = WeatherDTO(
            "", Clouds(0), 5, Coord(10.0, 10.0), 5, 5, Main(5.0, 5, 5, 2.0, 2.0, 1.9), "fake",
            Sys("fake", 0, 0, 0, 0), 5, 4, listOf(), Wind(1, 1.0)
        )

    }


    @Test
    fun `test if fetchWeather method by cityName throws correct exception when a non String type or an empty String are received as input`() {
        runBlocking {
            var e1: Exception? = null
            var e2: Exception? = null

            try {
                fetchWeather("", FetchingMethod.BY_NAME)
            } catch (exception: Exception) {
                e1 = exception

            }




            try {
                fetchWeather(15, FetchingMethod.BY_NAME)
            } catch (exception: Exception) {

                e2 = exception
            }


            assert(e1 is IllegalStateException && e1.message == "Empty city name provided" && e2 is IllegalStateException && e2.message == "Invalid type provided")
        }


    }


    @Test
    fun `test if fetchWeather method by coordinates throws correct exception when a non Pair type or a Pair of non doubles are received as input`() {
        runBlocking {
            var e1: Exception? = null
            var e2: Exception? = null
            try {
                fetchWeather(" ", FetchingMethod.BY_COORDINATES)
            } catch (exception: Exception) {
                e1 = exception


            }

            try {
                fetchWeather(Pair("1", "2"), FetchingMethod.BY_COORDINATES)
            } catch (exception: Exception) {
                e2 = exception


            }

            assert(e1 is IllegalStateException && e1.message == "Invalid type provided" && e2 is IllegalStateException && e2.message == "Invalid type provided")

        }


    }

    @Test
    fun `test if method should return the same object provided by the repository function`() {
        runBlocking {
            `when`(remoteWeatherRepository.getWeatherDetailsByCityName(anyString())).thenReturn(
                fakeDTO
            )
            `when`(
                remoteWeatherRepository.getWeatherDetailsByCoordinates(
                    anyDouble(),
                    anyDouble()
                )
            ).thenReturn(
                fakeDTO
            )

            val fetchWeatherByCityName = fetchWeather("fake", FetchingMethod.BY_NAME)
            val fetchWeatherByCoordinates =
                fetchWeather(Pair(55.0, 44.0), FetchingMethod.BY_COORDINATES)

            assert(fetchWeatherByCityName == fakeDTO && fetchWeatherByCoordinates == fakeDTO)
        }


    }

}