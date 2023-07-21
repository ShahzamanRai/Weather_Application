package com.shahzaman.weather.weatherFeature.presentation.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.shahzaman.weather.weatherFeature.presentation.MainActivity

val BlueColorScheme = darkColorScheme(
    primary = Blue,
    surface = Black,
    onSurface = White,
    background = Blue,
    onBackground = Black
)
val PinkColorScheme = darkColorScheme(
    primary = Pink,
    surface = Black,
    onSurface = White,
    background = Pink,
    onBackground = Black
)
val YellowColorScheme = darkColorScheme(
    primary = Yellow,
    surface = Black,
    onSurface = White,
    background = Yellow,
    onBackground = Black
)

@Composable
fun WeatherTheme(
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = MainActivity.selectedColorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
        }
    }

    MaterialTheme(
        colorScheme = MainActivity.selectedColorScheme,
        typography = Typography,
        content = content
    )
}