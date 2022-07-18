package com.example.psaweathertest.presentation.cities_list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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

                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    elevation = 12.dp
                ) {
                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            text = it.city,
                            modifier = Modifier.padding(16.dp)
                        )
                        Text(
                            text = it.description,
                            modifier = Modifier.padding(16.dp)
                        )
                        Text(
                            text = it.main,
                            modifier = Modifier.padding(16.dp)
                        )
                    }

                }

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