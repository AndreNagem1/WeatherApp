package praonde.com.wheatherapp.home.presentation.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import praonde.com.uikit.commonUI.BaseScreen
import praonde.com.uikit.commonUI.SearchComponent
import praonde.com.wheatherapp.home.presentation.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(
    viewmodel: HomeScreenViewModel = hiltViewModel()
) {
    BaseScreen {
        SearchComponent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, top = 44.dp, end = 24.dp),
            value = ""
        ) { _ ->

        }
    }
}