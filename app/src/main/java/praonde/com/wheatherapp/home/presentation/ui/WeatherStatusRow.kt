package praonde.com.wheatherapp.home.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import praonde.com.uikit.theme.WeatherAppTheme
import praonde.com.wheatherapp.R

@Composable
fun WeatherStatusRow() {
    Box(
        modifier = Modifier
            .padding(horizontal = 50.dp)
            .background(
                color = WeatherAppTheme.colors.surface,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            WeatherStatusRowItem(
                title = stringResource(R.string.weather_status_humidity),
                value = "20%"
            )
            WeatherStatusRowItem(
                title = stringResource(R.string.weather_status_uv),
                value = "4"
            )
            WeatherStatusRowItem(
                title = stringResource(R.string.weather_status_feels_like),
                value = "38°"
            )
        }
    }
}

@Composable
fun WeatherStatusRowItem(title: String, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = title,
            color = WeatherAppTheme.colors.textLightColor,
            style = WeatherAppTheme.typography.displayExtraSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            textAlign = TextAlign.Center,
            text = value,
            color = WeatherAppTheme.colors.textLightDarkColor,
            style = WeatherAppTheme.typography.displaySmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherStatusRowPreview() {
    WeatherStatusRow()
}