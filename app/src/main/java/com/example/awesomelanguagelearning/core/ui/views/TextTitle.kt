package com.example.awesomelanguagelearning.core.ui.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme

@Composable
fun TextTitle(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = AppTheme.typography.bodyM,
    textColor: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        modifier = modifier,
        text = text,
        color = textColor,
        style = textStyle,
        textAlign = textAlign
    )
}

@Preview(showBackground = true)
@Composable
private fun TextTitlePreview() {
    AppTheme {
        TextTitle(
            text = "some title"
        )
    }
}