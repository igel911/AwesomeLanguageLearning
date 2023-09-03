package com.example.awesomelanguagelearning.core.ui.views

import androidx.annotation.StringRes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.awesomelanguagelearning.core.ui.theme.AwesomeLanguageLearningTheme

@Composable
fun TextTitle(
    @StringRes textId: Int,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = AwesomeLanguageLearningTheme.typography.bodyM,
    textColor: Color = Color.Black
) {
    TextTitle(
        modifier = modifier,
        text = stringResource(textId),
        textStyle = textStyle,
        textColor = textColor
    )
}

@Composable
fun TextTitle(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = AwesomeLanguageLearningTheme.typography.bodyM,
    textColor: Color = Color.Black
) {
    Text(
        modifier = modifier,
        text = text,
        color = textColor,
        style = textStyle
    )
}

@Preview(showBackground = true)
@Composable
fun TextTitlePreview() {
    AwesomeLanguageLearningTheme {
        TextTitle(
            text = "some title"
        )
    }
}