package com.example.awesomelanguagelearning.core.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.awesomelanguagelearning.R

val Typography = ComposeTypography(
    h4 = TextStyle(
        fontFamily = FontFamily(Font(R.font.fredoka_semi_bold)),
        fontSize = 28.sp,
        lineHeight = 34.sp
    ),
    h5 = TextStyle(
        fontFamily = FontFamily(Font(R.font.fredoka_semi_bold)),
        fontSize = 22.sp,
        lineHeight = 28.sp
    ),
    h6 = TextStyle(
        fontFamily = FontFamily(Font(R.font.fredoka_semi_bold)),
        fontSize = 20.sp,
        lineHeight = 24.sp
    ),
    bodyL = TextStyle(
        fontFamily = FontFamily(Font(R.font.fredoka_regular)),
        fontSize = 17.sp,
        lineHeight = 22.sp
    ),
    bodyM = TextStyle(
        fontFamily = FontFamily(Font(R.font.fredoka_regular)),
        fontSize = 15.sp,
        lineHeight = 20.sp
    ),
    bodyS = TextStyle(
        fontFamily = FontFamily(Font(R.font.fredoka_regular)),
        fontSize = 13.sp,
        lineHeight = 18.sp
    ),
    bodyBoldL = TextStyle(
        fontFamily = FontFamily(Font(R.font.fredoka_medium)),
        fontSize = 17.sp,
        lineHeight = 22.sp
    ),
    bodyBoldM = TextStyle(
        fontFamily = FontFamily(Font(R.font.fredoka_medium)),
        fontSize = 15.sp,
        lineHeight = 20.sp
    ),
    bodyBoldS = TextStyle(
        fontFamily = FontFamily(Font(R.font.fredoka_medium)),
        fontSize = 13.sp,
        lineHeight = 18.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily(Font(R.font.fredoka_regular)),
        fontSize = 11.sp,
        lineHeight = 14.sp
    ),
    captionBold = TextStyle(
        fontFamily = FontFamily(Font(R.font.fredoka_medium)),
        fontSize = 11.sp,
        lineHeight = 14.sp
    )
)

@Immutable
data class ComposeTypography(
    val h4: TextStyle = TextStyle.Default,
    val h5: TextStyle = TextStyle.Default,
    val h6: TextStyle = TextStyle.Default,
    val bodyL: TextStyle = TextStyle.Default,
    val bodyM: TextStyle = TextStyle.Default,
    val bodyS: TextStyle = TextStyle.Default,
    val bodyBoldL: TextStyle = TextStyle.Default,
    val bodyBoldM: TextStyle = TextStyle.Default,
    val bodyBoldS: TextStyle = TextStyle.Default,
    val caption: TextStyle = TextStyle.Default,
    val captionBold: TextStyle = TextStyle.Default
)