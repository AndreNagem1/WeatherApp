package praonde.com.wheatherapp.home.presentation.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import praonde.com.wheatherapp.common.SubmitLoadingState

@Composable
fun HomeScreenContent(state: SubmitLoadingState<String>) {

    when (state) {
        SubmitLoadingState.Idle -> HomeIdleText()

        SubmitLoadingState.Loading -> {
            WeatherStatus()
            Spacer(modifier = Modifier.height(35.dp))
            WeatherStatusRow()
        }

        is SubmitLoadingState.Success -> {
            LazyColumn(
                modifier = Modifier.padding(top = 32.dp)
            ) {
                items(listSearchItems.size) { index ->
                    if (index > 0) {
                        Spacer(modifier = Modifier.height(32.dp))
                    }
                    SearchListItem()
                }
            }
        }

        else -> {}
    }
}

private val listSearchItems = listOf("", "", "", "", "")
