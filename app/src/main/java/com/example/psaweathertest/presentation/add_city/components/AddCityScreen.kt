package com.example.psaweathertest.presentation.add_city.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.psaweathertest.presentation.add_city.AddCityViewModel
import com.example.psaweathertest.presentation.common_components.CustomButton


@Composable
fun AddCityScreen(
    navHostController: NavHostController,
    addCityViewModel: AddCityViewModel = hiltViewModel()
) {
    Box(modifier = Modifier.fillMaxSize()) {


        Column(Modifier.align(Alignment.Center)) {


            CustomTextField(
                Modifier.align(CenterHorizontally),
                text = addCityViewModel.cityName.value,
                placeholder = "City name",
                onChange = {
                    addCityViewModel.cityName.value = it
                },


                )
            CustomButton(text = "Add city", modifier = Modifier.align(CenterHorizontally)) {

            }
        }

    }
}