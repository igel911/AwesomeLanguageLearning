package com.example.awesomelanguagelearning.home.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.TextTitle
import com.example.awesomelanguagelearning.home.ui.MainNavigation

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(AppTheme.colors.grayLight)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        TextTitle(
            text = MainNavigation.Home.route,
            textStyle = AppTheme.typography.h4,

        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AppTheme {
        HomeScreen()
    }
}