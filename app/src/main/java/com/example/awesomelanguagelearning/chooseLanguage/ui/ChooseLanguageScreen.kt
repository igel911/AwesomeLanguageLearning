package com.example.awesomelanguagelearning.chooseLanguage.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.TextTitle
import com.example.awesomelanguagelearning.core.ui.views.Toolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChooseLanguageScreen(
    navigateToNextScreen: () -> Unit = {},
    navigateBack: () -> Unit = {}
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Toolbar(
                text = stringResource(R.string.complited),
                icon = Icons.Filled.KeyboardArrowLeft,
                onIconClick = navigateBack
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextTitle(
                    text = "Choose language",
                    textStyle = AppTheme.typography.h4
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ChooseLanguageScreenPreview() {
    AppTheme {
        ChooseLanguageScreen()
    }
}