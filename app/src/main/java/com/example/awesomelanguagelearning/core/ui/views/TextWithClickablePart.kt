package com.example.awesomelanguagelearning.core.ui.views

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.utils.TextColorData
import com.example.awesomelanguagelearning.core.ui.utils.TextStyleData

@Composable
fun TextWithClickablePart(
    regularText: String,
    clickableText: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = { },
    textColorData: TextColorData = TextColorData(
        regular = AppTheme.colors.grayMedium,
        clickable = AppTheme.colors.black
    ),
    textStyleData: TextStyleData = TextStyleData(
        regular = AppTheme.typography.bodyM,
        clickable = AppTheme.typography.bodyBoldM
    )
) {
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = regularStyle(
                textColorData = textColorData,
                textStyleData = textStyleData
            )
        ) {
            append(regularText)
            append(" ")
        }

        withStyle(
            style = clickableStyle(
                textColorData = textColorData,
                textStyleData = textStyleData
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
    textColorData: TextColorData,
    textStyleData: TextStyleData
) = SpanStyle(
    color = textColorData.regular,
    fontStyle = textStyleData.regular.fontStyle,
    fontSize = textStyleData.regular.fontSize
)

@Composable
private fun clickableStyle(
    textColorData: TextColorData,
    textStyleData: TextStyleData
) = SpanStyle(
    color = textColorData.clickable,
    fontStyle = textStyleData.clickable.fontStyle,
    fontSize = textStyleData.clickable.fontSize,
    fontWeight = textStyleData.clickable.fontWeight
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