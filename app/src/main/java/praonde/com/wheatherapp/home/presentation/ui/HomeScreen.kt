package praonde.com.wheatherapp.home.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import praonde.com.uikit.commonUI.BaseScreen
import praonde.com.uikit.commonUI.SearchComponent
import praonde.com.wheatherapp.home.presentation.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(viewmodel: HomeScreenViewModel = hiltViewModel()) {
    val state = viewmodel.state.collectAsState()

    BaseScreen {
        SearchComponent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 44.dp, end = 24.dp),
            value = state.value.searchText,
            onValueChange = viewmodel::onSearchTextChange
        )

        if (state.value.showWeatherDetails) {
            WeatherStatus()
            Spacer(modifier = Modifier.height(35.dp))
            WeatherStatusRow()
        } else {
            HomeScreenContent(
                state = state.value.weatherDataSubmittable,
                onSearchItemClick = { _ ->
                    viewmodel.onSearchItemClick()
                }
            )
        }
    }
}