package com.example.awesomelanguagelearning.core.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Timer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme

@Composable
fun TextTitleLeadingIcon(
    text: String,
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = AppTheme.typography.bodyM,
    textColor: Color = Color.Black,
    textAlign: TextAlign = TextAlign.Start,
    imageColor: Color = Color.Black,
    contentDescription: String = ""
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            imageVector = imageVector,
            colorFilter = ColorFilter.tint(color = imageColor),
            contentDescription = contentDescription
        )

        TextTitle(
            text = text,
            textStyle = textStyle,
            textColor = textColor,
            textAlign = textAlign
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    AppTheme {
        TextTitleLeadingIcon(
            text = "some title",
            imageVector = Icons.Filled.Timer
        )
    }
}