package praonde.com.uikit.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf


val LocalAppColors = staticCompositionLocalOf {
    WeatherAppColorsPalette
}

val LocalAppTypography = staticCompositionLocalOf {
    AppTypographyConst
}

@Composable
fun WeatherAppThemeWrapper(
    colorPalette: WeatherAppColors = WeatherAppColorsPalette,
    content: @Composable () -> Unit
) {
    MaterialTheme {
        CompositionLocalProvider(
            LocalAppColors provides colorPalette,
            LocalAppTypography provides AppTypographyConst,
            content = content,
        )
    }
}

object WeatherAppThemeWrapper {
    val colors: WeatherAppColors
        @Composable
        get() = LocalAppColors.current
    val typography: BsTypography
        @Composable
        get() = LocalAppTypography.current
}