package praonde.com.uikit.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class WeatherAppColors(
    val white: Color,
    val background: Color,
    val surface: Color,
    val textLightColor: Color,
    val textLightDarkColor: Color,
    val textDarkColor: Color
)

internal val WeatherAppColorsPalette = WeatherAppColors(
    white = Color.White,
    background = Color(0xFFFAFAFA),
    surface = Color(0xFFF2F2F2),
    textLightColor = Color(0xFFC4C4C4),
    textDarkColor = Color(0xFF2C2C2C),
    textLightDarkColor = Color(0xFF9A9A9A),
)