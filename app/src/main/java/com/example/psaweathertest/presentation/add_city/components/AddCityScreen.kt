package com.example.psaweathertest.presentation.add_city.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.psaweathertest.presentation.Screen
import com.example.psaweathertest.presentation.add_city.AddCityViewModel
import com.example.psaweathertest.presentation.common_components.CustomButton


@Composable
fun AddCityScreen(
    navHostController: NavHostController,
    addCityViewModel: AddCityViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        if (addCityViewModel.cityWeatherState.value.loading)
            CircularProgressIndicator(modifier = Modifier.align(Center))
        else if (addCityViewModel.cityWeatherState.value.error.isNotBlank())
            LaunchedEffect(key1 = true) {
                Toast.makeText(
                    context,
                    addCityViewModel.cityWeatherState.value.error,
                    Toast.LENGTH_SHORT
                ).show()
            }
        else if (addCityViewModel.cityWeatherState.value.weatherData != null) {
            LaunchedEffect(key1 = true) {
                Toast.makeText(context, "City added successfully", Toast.LENGTH_SHORT).show()
                navHostController.navigate(Screen.CitiesList.route)
            }


        }







        Column(Modifier.align(Center)) {


            CustomTextField(
                Modifier.align(CenterHorizontally),
                text = addCityViewModel.cityName.value,
                placeholder = "City name",
                onChange = {
                    addCityViewModel.cityName.value = it
                },


                )
            CustomButton(
                text = "Submit",
                enabled = addCityViewModel.cityName.value.length > 1,
                modifier = Modifier.align(CenterHorizontally),
                onClick = {
                    addCityViewModel.searchAndSaveCity()
                })
        }

    }
}