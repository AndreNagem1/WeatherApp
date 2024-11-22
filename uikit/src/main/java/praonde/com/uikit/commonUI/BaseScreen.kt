package praonde.com.uikit.commonUI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import praonde.com.uikit.theme.WeatherAppTheme

@Composable
fun BaseScreen(
    content: @Composable () -> Unit
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .background(WeatherAppTheme.colors.background)
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            content()
        }
    }

}