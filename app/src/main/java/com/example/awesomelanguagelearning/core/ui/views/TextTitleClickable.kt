package com.example.awesomelanguagelearning.core.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme

@Composable
fun TextTitleClickable(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = AppTheme.typography.bodyM,
    textColor: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Start,
    onClick: () -> Unit = {}
) {
    Text(
        modifier = modifier.clickable(
            interactionSource = MutableInteractionSource(),
            indication = rememberRipple(bounded = true, color = AppTheme.colors.grayMedium)
        ) { onClick() },
        text = text,
        color = textColor,
        style = textStyle,
        textAlign = textAlign
    )
}

@Preview(showBackground = true)
@Composable
fun TextTitleClickablePreview() {
    AppTheme {
        TextTitleClickable(
            text = "some title"
        )
    }
}