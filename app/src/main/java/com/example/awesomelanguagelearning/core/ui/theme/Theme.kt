package com.example.awesomelanguagelearning.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalTypography provides Typography,
        LocalColors provides Colors,
        LocalShapes provides MyShapes,
        content = content
    )

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(color = Colors.purple)
}

object AppTheme {

    val colors: ComposeColors
        @Composable
        get() = LocalColors.current

    val typography: ComposeTypography
        @Composable
        get() = LocalTypography.current

    val shapes: ComposeShapes
        @Composable
        get() = LocalShapes.current
}