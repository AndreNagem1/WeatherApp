package praonde.com.uikit.commonUI

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import praonde.com.uikit.theme.WeatherAppTheme

@Composable
fun ScreenMessageComponent(titleResource: Int, descriptionResource: Int) {
    Text(
        modifier = Modifier
            .padding(start = 48.dp, end = 48.dp, top = 240.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        text = stringResource(titleResource),
        color = WeatherAppTheme.colors.textDarkColor,
        style = WeatherAppTheme.typography.displayMedium
    )

    Text(
        modifier = Modifier
            .padding(start = 48.dp, end = 48.dp, top = 10.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        text = stringResource(descriptionResource),
        color = WeatherAppTheme.colors.textDarkColor,
        style = WeatherAppTheme.typography.displaySmall
    )
}