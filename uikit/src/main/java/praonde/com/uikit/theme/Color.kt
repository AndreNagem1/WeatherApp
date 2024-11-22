package praonde.com.uikit.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class WeatherAppColors(
    val white: Color,
    val background: Color,
    val surface: Color,
    val textColor: Color
)

internal val WeatherAppColorsPalette = WeatherAppColors(
    white = Color.White,
    background = Color(0xFFFAFAFA),
    surface = Color(0xFFF2F2F2),
    textColor =  Color(0xFFC4C4C4)
)