package praonde.com.wheatherapp.home.presentation.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import praonde.com.uikit.commonUI.LoadingComponent
import praonde.com.uikit.commonUI.ScreenMessageComponent
import praonde.com.wheatherapp.R
import praonde.com.wheatherapp.common.LoadingEvent
import praonde.com.wheatherapp.home.domain.model.PlaceInfo

@Composable
fun HomeScreenContent(
    state: LoadingEvent<List<PlaceInfo>>,
    onSearchItemClick: (Int) -> Unit
) {
    when (state) {
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
                        placeName = placeInfo.name,
                        onSearchListItemClick = { onSearchItemClick(placeInfo.id) }
                    )
                }
            }
        }

        LoadingEvent.Loading -> {
            LoadingComponent()
        }

        LoadingEvent.Idle -> ScreenMessageComponent(
            titleResource = R.string.home_screen_idle_title,
            descriptionResource = R.string.home_screen_idle_description
        )

        is LoadingEvent.Error -> ScreenMessageComponent(
            titleResource = R.string.home_screen_idle_title,
            descriptionResource = R.string.home_screen_idle_description
        )
    }
}
