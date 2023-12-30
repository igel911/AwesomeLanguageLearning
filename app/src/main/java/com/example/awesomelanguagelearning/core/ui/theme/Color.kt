package com.example.awesomelanguagelearning.core.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

val Purple = Color(0xFF410FA3)
val BlueDark = Color(0xFF5B7BFE)
val Orange = Color(0xFFF76400)
val GreenDark = Color(0xFF5BA890)
val Red = Color(0xFFD6185D)
val GreenLight = Color(0xFF00B5AE)
val Yellow = Color(0xFFFFF6EB)
val BlueLight = Color(0xFFDBF6FF)
val White = Color(0xFFFFFFFF)
val Black = Color(0xFF080E1E)
val GrayDark = Color(0xFF363B44)
val GrayMedium = Color(0xFF656872)
val GrayLight = Color(0xFFE5E5E5)

val Colors = ComposeColors(
    purple = Purple,
    blueDark = BlueDark,
    orange = Orange,
    greenDark = GreenDark,
    red = Red,
    greenLight = GreenLight,
    yellow = Yellow,
    blueLight = BlueLight,
    white = White,
    black = Black,
    grayDark = GrayDark,
    grayMedium = GrayMedium,
    grayLight = GrayLight
)

@Immutable
data class ComposeColors(
    val purple: Color = Color.Transparent,
    val blueDark: Color = Color.Transparent,
    val orange: Color = Color.Transparent,
    val orangeLight: Color = orange.copy(alpha = 0.2f),
    val greenDark: Color = Color.Transparent,
    val red: Color = Color.Transparent,
    val greenLight: Color = Color.Transparent,
    val yellow: Color = Color.Transparent,
    val blueLight: Color = Color.Transparent,
    val white: Color = Color.Transparent,
    val black: Color = Color.Transparent,
    val grayDark: Color = Color.Transparent,
    val grayMedium: Color = Color.Transparent,
    val grayLight: Color = Color.Transparent
)