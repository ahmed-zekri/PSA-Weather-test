package com.example.psaweathertest.presentation.cities_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.psaweathertest.presentation.Screen
import com.example.psaweathertest.presentation.cities_list.CitiesListViewModel

@Composable
fun CitiesListScreen(
    navHostController: NavHostController,
    citiesListViewModel: CitiesListViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        LazyColumn(Modifier.align(CenterHorizontally)) {
            items(citiesListViewModel.citiesWeatherList.value) {

                Text(text = it.city)

            }

        }
        Row(Modifier.align(CenterHorizontally)) {
            Button(onClick = {
                navHostController.navigate(Screen.AddCity.route)


            }) {
                Text(text = "Add city")
            }

        }


    }

}