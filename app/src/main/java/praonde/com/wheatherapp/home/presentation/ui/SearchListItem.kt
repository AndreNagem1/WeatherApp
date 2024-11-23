package praonde.com.wheatherapp.home.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import praonde.com.uikit.theme.WeatherAppTheme
import praonde.com.wheatherapp.R

@Composable
fun SearchListItem(
    placeName: String,
    onSearchListItemClick: () -> Unit
) {
    val placeNameFormatted = if (placeName.length > 13) {
        placeName.substring(0, 10) + "..."
    } else {
        placeName
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSearchListItemClick() }
            .background(
                color = WeatherAppTheme.colors.surface,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 31.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SearchListItemFirstComponent(
                title = placeNameFormatted,
                value = "20°"
            )
            Spacer(modifier = Modifier.weight(1F))
            Image(
                modifier = Modifier.size(83.dp),
                painter = painterResource(R.drawable.status_cloudy),
                contentDescription = "WeatherStatusImage"
            )
        }
    }
}

@Composable
fun SearchListItemFirstComponent(title: String, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = title,
            color = WeatherAppTheme.colors.textDarkColor,
            style = WeatherAppTheme.typography.displaySemiMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            textAlign = TextAlign.Center,
            text = value,
            color = WeatherAppTheme.colors.textDarkColor,
            style = WeatherAppTheme.typography.displaySemiLarge
        )
    }
}