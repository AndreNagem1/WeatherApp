package praonde.com.uikit.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class WeatherAppColors(
    val white: Color,
    val background: Color,
)

internal val WeatherAppColorsPalette = WeatherAppColors(
    white = Color.White,
    background = Color(0xFFFAFAFA),
)