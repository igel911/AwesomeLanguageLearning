package com.example.awesomelanguagelearning.home.ui.views.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.TextTitle

@Composable
fun HomeListTitle(
    topText: String,
    bottomText: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextTitle(
            text = topText,
            textStyle = AppTheme.typography.h6
        )

        TextTitle(
            text = bottomText,
            textColor = AppTheme.colors.grayMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeListTitlePreview() {
    AppTheme {
        HomeListTitle(
            topText = "First text",
            bottomText = "Second text"
        )
    }
}