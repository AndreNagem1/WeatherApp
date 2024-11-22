package praonde.com.uikit.commonUI

import android.annotation.SuppressLint
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import praonde.com.uikit.theme.WeatherAppTheme
import wheatherapp.com.uikit.R

@Composable
fun SearchComponent(
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedTextColor = WeatherAppTheme.colors.surface,
        unfocusedTextColor = WeatherAppTheme.colors.surface,
        focusedBorderColor = WeatherAppTheme.colors.surface,
        unfocusedBorderColor = WeatherAppTheme.colors.surface,
        focusedContainerColor = WeatherAppTheme.colors.surface,
        unfocusedContainerColor = WeatherAppTheme.colors.surface,
        errorBorderColor = WeatherAppTheme.colors.surface,
        errorTextColor = WeatherAppTheme.colors.surface,
        errorLabelColor = WeatherAppTheme.colors.surface,
        errorContainerColor = WeatherAppTheme.colors.white,
        errorTrailingIconColor = WeatherAppTheme.colors.surface,
        errorLeadingIconColor = WeatherAppTheme.colors.surface
    ),
    trailingIcon: @Composable (() -> Unit)? = { DefaultSearchComponentIcon() },
    @SuppressLint("ModifierParameter") modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(16.dp),
        colors = colors,
        trailingIcon = trailingIcon,
        placeholder = {
            Text(
                stringResource(R.string.search_component_hint),
                color = WeatherAppTheme.colors.textLightColor,
                style = WeatherAppTheme.typography.labelSmall
            )
        }
    )
}

@Composable
fun DefaultSearchComponentIcon() {
    Icon(
        painterResource(R.drawable.ic_search),
        tint = WeatherAppTheme.colors.textLightColor,
        contentDescription = "SearchComponentIcon"
    )
}


@Preview(showBackground = true)
@Composable
fun SearchComponentPreview() {
    SearchComponent(
        modifier = Modifier,
        value = ""
    ) { _ -> }
}