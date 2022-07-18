package com.example.psaweathertest.presentation.cities_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.psaweathertest.presentation.Screen

@Composable
fun CitiesListScreen(navHostController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        LazyColumn(Modifier.align(CenterHorizontally)) {


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