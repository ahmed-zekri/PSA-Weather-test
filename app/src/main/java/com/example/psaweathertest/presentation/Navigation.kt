package com.example.psaweathertest.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.psaweathertest.common.CITY_PARAM
import com.example.psaweathertest.presentation.cities_list.components.CitiesList

@Composable
fun Navigation() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.CitiesList.route) {

        composable(route = Screen.CitiesList.route) {
            CitiesList(navController)

        }

        composable(route = Screen.AddCity.route) {


        }
        composable(route = Screen.CityWeather("{$CITY_PARAM}").route) {


        }

    }


}