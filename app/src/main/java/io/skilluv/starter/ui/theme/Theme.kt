package io.skilluv.starter.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColors = darkColorScheme(
    primary = Color(0xFF34D399),
    onPrimary = Color(0xFF00201A),
    background = Color(0xFF020617),
    surface = Color(0xFF0F172A),
)

private val LightColors = lightColorScheme(
    primary = Color(0xFF059669),
    onPrimary = Color.White,
)

@Composable
fun SkilluvTheme(useDark: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = if (useDark) DarkColors else LightColors, content = content)
}
