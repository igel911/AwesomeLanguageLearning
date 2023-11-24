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
    firstText: String,
    secondText: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextTitle(
            text = firstText,
            textStyle = AppTheme.typography.h6
        )

        TextTitle(
            text = secondText,
            textColor = AppTheme.colors.grayMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeListTitlePreview() {
    AppTheme {
        HomeListTitle(
            firstText = "First text",
            secondText = "Second text"
        )
    }
}