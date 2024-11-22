package praonde.com.wheatherapp.home.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
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
    val context = LocalContext.current
    val state = viewmodel.state.collectAsState()

    BaseScreen {
        SearchComponent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 44.dp, end = 24.dp),
            value = state.value.searchText,
            onValueChange = viewmodel::onSearchTextChange
        )

        HomeScreenContent(
            state = state.value.weatherDataSubmittable,
            onSearchItemClick = { index ->
                Toast.makeText(context, "Search Item $index", Toast.LENGTH_SHORT).show()
            }
        )
    }
}