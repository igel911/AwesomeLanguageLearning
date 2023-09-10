package com.example.awesomelanguagelearning.core.ui.views

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme

@Composable
fun TextWithClickablePart(
    regularText: String,
    clickableText: String,
    modifier: Modifier = Modifier,
    textColor: Color = AppTheme.colors.grayMedium,
    textStyle: TextStyle = AppTheme.typography.bodyM,
    clickableTextColor: Color = AppTheme.colors.black,
    clickableTextStyle: TextStyle = AppTheme.typography.bodyBoldM,
    onClick: () -> Unit = { }
) {
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = regularStyle(
                textStyle = textStyle,
                textColor = textColor
            )
        ) {
            append(regularText)
            append(" ")
        }

        withStyle(
            style = clickableStyle(
                textStyle = clickableTextStyle,
                textColor = clickableTextColor
            )
        ) {
            pushStringAnnotation(
                tag = clickableText,
                annotation = clickableText
            )
            append(clickableText)
        }
    }

    ClickableText(
        modifier = modifier,
        text = annotatedText,
        style = TextStyle(textAlign = TextAlign.Center),
        onClick = { offset ->
            annotatedText.getStringAnnotations(
                tag = clickableText,
                start = offset,
                end = offset
            ).firstOrNull()?.let { onClick() }
        }
    )
}

@Composable
private fun regularStyle(
    textStyle: TextStyle,
    textColor: Color
) = SpanStyle(
    color = textColor,
    fontStyle = textStyle.fontStyle,
    fontSize = textStyle.fontSize
)

@Composable
private fun clickableStyle(
    textStyle: TextStyle,
    textColor: Color
) = SpanStyle(
    color = textColor,
    fontStyle = textStyle.fontStyle,
    fontSize = textStyle.fontSize,
    fontWeight = textStyle.fontWeight
)

@Preview(showBackground = true)
@Composable
fun TextWithClickablePartPreview() {
    AppTheme {
        TextWithClickablePart(
            regularText = "Wanna click?",
            clickableText = "Then click"
        )
    }
}