package praonde.com.wheatherapp.home.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import praonde.com.uikit.theme.WeatherAppTheme
import praonde.com.wheatherapp.R
import praonde.com.wheatherapp.home.domain.model.Condition

@Composable
fun WeatherStatus(condition: Condition, temp: Double) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(123.dp),
            painter = painterResource(condition.resourceID),
            contentDescription = "WeatherStatusImage"
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .padding(start = 48.dp, end = 48.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = condition.description,
                color = WeatherAppTheme.colors.textDarkColor,
                style = WeatherAppTheme.typography.displayMedium
            )
            Spacer(modifier = Modifier.width(11.dp))
            Icon(
                painter = painterResource(R.drawable.ic_weather_arrow),
                contentDescription = "WeatherStatusIcon"
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .padding(start = 48.dp, end = 48.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = temp.toString(),
                color = WeatherAppTheme.colors.textDarkColor,
                style = WeatherAppTheme.typography.displayLarge
            )
            Icon(
                modifier = Modifier.padding(top = 15.dp),
                painter = painterResource(R.drawable.ic_elipse),
                contentDescription = "WeatherStatusIcon"
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WeatherStatusPreview() {
    WeatherStatus(
        condition = Condition.CONDITION_3,
        temp = 22.23
    )
}