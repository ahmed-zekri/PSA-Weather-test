import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.psaweathertest.presentation.city_details.CityDetailsViewModel

@Composable
fun CityDetails(
    navHostController: NavHostController,
    cityDetailsViewModel: CityDetailsViewModel = hiltViewModel()
) {
    Text(text = cityDetailsViewModel.weatherDetails.value?.main ?: "")

}