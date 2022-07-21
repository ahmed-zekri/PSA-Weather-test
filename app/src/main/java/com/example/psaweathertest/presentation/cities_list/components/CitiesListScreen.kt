package com.example.psaweathertest.presentation.cities_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.psaweathertest.common.getImageIdByName
import com.example.psaweathertest.domain.use_case.utils.CitiesWeatherDetailsOrder
import com.example.psaweathertest.domain.use_case.utils.CitiesWeatherDetailsOrderType
import com.example.psaweathertest.presentation.Screen
import com.example.psaweathertest.presentation.cities_list.CitiesListViewModel
import com.example.psaweathertest.presentation.common_components.CustomButton

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CitiesListScreen(
    navHostController: NavHostController,
    citiesListViewModel: CitiesListViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 45.dp)
        ) {
            RadioButtonComponent(
                radioOptions = listOf("By city name", "By temp")

            ) {
                citiesListViewModel.updateOrderState(
                    if (contains("name"))
                        CitiesWeatherDetailsOrder.CityName() else CitiesWeatherDetailsOrder.Temp()
                )

                citiesListViewModel.getList()
            }

            RadioButtonComponent(
                radioOptions = listOf("Ascending", "Descending")

            ) {

                citiesListViewModel.updateOrderTypeState(
                    if (contains("Ascending"))
                        CitiesWeatherDetailsOrderType.Ascending else CitiesWeatherDetailsOrderType.Descending
                )
                citiesListViewModel.getList()


            }
            if (citiesListViewModel.citiesWeatherListState.value.isNotEmpty())
                LazyColumn(
                    Modifier
                        .align(CenterHorizontally)

                ) {
                    items(citiesListViewModel.citiesWeatherList.value) {

                        Card(
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth(),
                            elevation = 12.dp, backgroundColor = Color.LightGray, onClick = {

                                navHostController.navigate(Screen.CityWeather(it.city).route)
                            }
                        ) {
                            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                                Row {
                                    Text(
                                        text = it.city,
                                        modifier = Modifier.padding(16.dp)
                                    )
                                }
                                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                                    Text(
                                        text = it.description,
                                        modifier = Modifier.padding(15.dp)
                                    )
                                    Image(
                                        painterResource(id = context.getImageIdByName("a${it.icon}")),
                                        modifier = Modifier.padding(16.dp),
                                        contentDescription = "Weather icon"
                                    )
                                }

                            }

                        }

                    }

                }
            else
                Text(
                    text = "No data found , please add a city by clicking on the button below",
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .align(CenterHorizontally)
                )


        }
        Row(Modifier.align(BottomCenter)) {
            CustomButton(modifier = Modifier.height(45.dp), onClick = {
                navHostController.navigate(Screen.AddCity.route)


            }, text = "Add city")

        }
    }
}