package praonde.com.uikit.commonUI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import praonde.com.uikit.theme.WeatherAppTheme

@Composable
fun LoadingComponent() {
    Column(
        modifier = Modifier
            .padding(top = 25.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            color = WeatherAppTheme.colors.textDarkColor
        )
    }
}