package praonde.com.wheatherapp.home.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import praonde.com.uikit.theme.WeatherAppTheme
import praonde.com.wheatherapp.common.LoadingEvent
import praonde.com.wheatherapp.home.data.entity.PlaceEntity

@Composable
fun HomeScreenContent(
    state: LoadingEvent<List<PlaceEntity>>,
    onSearchItemClick: (Int) -> Unit
) {
    when (state) {
        LoadingEvent.Loading -> {
            Column(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    color = WeatherAppTheme.colors.textDarkColor
                )
            }
        }

        LoadingEvent.Idle -> HomeIdleText()

        is LoadingEvent.Success -> {

            LazyColumn(
                modifier = Modifier.padding(top = 32.dp, start = 20.dp, end = 20.dp)
            ) {
                items(state.data.size) { index ->
                    val placeInfo = state.data[index]

                    if (index > 0) {
                        Spacer(modifier = Modifier.height(32.dp))
                    }
                    SearchListItem(
                        placeName = placeInfo.region,
                        onSearchListItemClick = { onSearchItemClick(index) }
                    )
                }
            }
        }

        else -> {}
    }
}
