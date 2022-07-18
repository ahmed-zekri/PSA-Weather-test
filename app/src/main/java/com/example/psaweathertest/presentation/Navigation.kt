package com.example.psaweathertest.presentation

import CityDetails
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.psaweathertest.common.CITY_PARAM
import com.example.psaweathertest.presentation.add_city.components.AddCityScreen
import com.example.psaweathertest.presentation.cities_list.components.CitiesListScreen

@Composable
fun Navigation() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.CitiesList.route) {

        composable(route = Screen.CitiesList.route) {
            CitiesListScreen(navController)

        }

        composable(route = Screen.AddCity.route) {
            AddCityScreen(navController)

        }
        composable(route = Screen.CityWeather("{$CITY_PARAM}").route) {
            CityDetails(navController)

        }

    }


}