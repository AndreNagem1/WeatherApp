package praonde.com.wheatherapp.home.presentation.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import praonde.com.uikit.commonUI.LoadingComponent
import praonde.com.uikit.commonUI.ScreenMessageComponent
import praonde.com.wheatherapp.R
import praonde.com.wheatherapp.common.LoadingEvent
import praonde.com.wheatherapp.home.domain.model.LocationDetails

@Composable
fun LocationDetailsContent(state: LoadingEvent<LocationDetails>) {

    when (state) {
        is LoadingEvent.Success -> {
            WeatherStatus(
                condition = state.data.condition,
                temp = state.data.temp
            )
            Spacer(modifier = Modifier.height(35.dp))
            WeatherStatusRow(
                humidity = state.data.humidity,
                uv = state.data.uv,
                tempFeelsLike = state.data.tempFeelsLike
            )
        }

        LoadingEvent.Idle -> ScreenMessageComponent(
            titleResource = R.string.home_screen_idle_title,
            descriptionResource = R.string.home_screen_idle_description
        )

        is LoadingEvent.Error -> ScreenMessageComponent(
            titleResource = R.string.screen_error_title,
            descriptionResource = R.string.screen_error_description
        )

        LoadingEvent.Loading -> LoadingComponent()
    }
}