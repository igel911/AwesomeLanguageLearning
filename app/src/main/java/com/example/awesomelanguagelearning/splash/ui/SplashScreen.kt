package com.example.awesomelanguagelearning.splash.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.views.HorizontalSpacer
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.TextTitle
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(
    navigateToNextScreen: () -> Unit = {}
) {
    val viewModel: SplashViewModel = koinViewModel()
    val nextScreenState by viewModel.goToNextScreenFlow.collectAsState(initial = false)
    if (nextScreenState) {
        navigateToNextScreen()
    }
    viewModel.startTimer()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.purple),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painterResource(R.drawable.splash_logo),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(164.dp)
                .height(152.dp)
        )

        HorizontalSpacer()

        TextTitle(
            text = stringResource(id = R.string.language_app),
            textColor = AppTheme.colors.white,
            textStyle = AppTheme.typography.h4
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    AppTheme {
        SplashScreen()
    }
}