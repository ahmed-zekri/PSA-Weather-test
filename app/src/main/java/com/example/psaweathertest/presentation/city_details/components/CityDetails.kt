import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.psaweathertest.common.getImageIdByName
import com.example.psaweathertest.presentation.city_details.CityDetailsViewModel
import com.example.psaweathertest.presentation.city_details.components.ExtraInfoRow

@Composable
fun CityDetails(
    navHostController: NavHostController,
    cityDetailsViewModel: CityDetailsViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    Box(
        Modifier
            .fillMaxSize()
            .padding(50.dp)
    ) {
        if (cityDetailsViewModel.weatherDetails.value != null)
            Column(modifier = Modifier.align(Alignment.Center)) {
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Image(
                        painter = painterResource(id = context.getImageIdByName("a${cityDetailsViewModel.weatherDetails.value?.icon}")),

                        contentDescription = "Weather icon", modifier = Modifier.scale(3f)
                    )

                    Text(
                        text = cityDetailsViewModel.weatherDetails.value!!.city,
                        fontWeight = Bold,
                        modifier = Modifier.padding(start = 45.dp),
                        fontSize = 27.sp
                    )


                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = cityDetailsViewModel.weatherDetails.value!!.description,

                        modifier = Modifier.padding(top = 30.dp),
                        fontSize = 27.sp
                    )


                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = cityDetailsViewModel.weatherDetails.value!!.temp.toString(),
                        fontWeight = Bold,
                        modifier = Modifier.padding(top = 30.dp),
                        fontSize = 27.sp
                    )


                    Text(
                        text = "o",
                        fontWeight = Bold,
                        modifier = Modifier.padding(top = 30.dp, start = 5.dp),
                        fontSize = 12.sp
                    )
                    Text(
                        text = "C",
                        fontWeight = Light,
                        modifier = Modifier.padding(top = 30.dp),
                        fontSize = 27.sp
                    )

                }

                ExtraInfoRow(
                    text =
                    "Max Temp: ${cityDetailsViewModel.weatherDetails.value!!.temp_max} F"
                )

                ExtraInfoRow(
                    text =
                    "Min Temp: ${cityDetailsViewModel.weatherDetails.value!!.temp_min} F"
                )
                ExtraInfoRow(
                    text =
                    "Humidity: ${cityDetailsViewModel.weatherDetails.value!!.humidity} %"
                )
                ExtraInfoRow(
                    text =
                    "Wind speed: ${cityDetailsViewModel.weatherDetails.value!!.windSpeed} m/s"
                )

                ExtraInfoRow(
                    text =
                    "Wind degree: ${cityDetailsViewModel.weatherDetails.value!!.windDegree}"
                )


                ExtraInfoRow(
                    text =
                    "Pressure: ${cityDetailsViewModel.weatherDetails.value!!.pressure} hpa"
                )

            }


    }


}