package praonde.com.wheatherapp.home.presentation.ui

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import praonde.com.uikit.commonUI.BaseScreen
import praonde.com.uikit.commonUI.SearchComponent
import praonde.com.wheatherapp.common.getSuccessDataOrNull
import praonde.com.wheatherapp.home.presentation.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(viewmodel: HomeScreenViewModel = hiltViewModel()) {
    val state = viewmodel.state.collectAsState()
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        val savedLocationId = getSavedLocationID(context)
        if (savedLocationId != -1) {
            viewmodel.getLocationDetails(locationID = savedLocationId)
        }
    }

    BaseScreen {
        SearchComponent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 44.dp, end = 24.dp),
            value = state.value.searchText,
            onValueChange = viewmodel::onSearchTextChange
        )

        if (state.value.showWeatherDetails) {
            val data = state.value.locationDetailsLoadingEvent.getSuccessDataOrNull()

            data?.let {
                saveLocationID(
                    context = context,
                    value = data.id
                )
            }

            LocationDetailsContent(state = state.value.locationDetailsLoadingEvent)
        } else {
            HomeScreenContent(
                state = state.value.listLocationsLoadingEvent,
                onSearchItemClick = { locationID ->
                    viewmodel.getLocationDetails(locationID = locationID)
                    focusManager.clearFocus()
                    keyboardController?.hide()
                }
            )
        }
    }
}


private fun saveLocationID(context: Context, value: Int) {
    val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    sharedPreferences.edit().putInt("locationID", value).apply()
}

private fun getSavedLocationID(context: Context): Int {
    val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    return sharedPreferences.getInt("locationID", -1)
}
