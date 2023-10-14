package com.example.awesomelanguagelearning.chooseLanguage.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.HorizontalSpacer
import com.example.awesomelanguagelearning.core.ui.views.TextButton
import com.example.awesomelanguagelearning.core.ui.views.TextTitle
import com.example.awesomelanguagelearning.core.ui.views.Toolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChooseLanguageFinalScreen(
    navigateToNextScreen: () -> Unit = {},
    navigateBack: () -> Unit = {}
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Toolbar(
                text = "",
                icon = Icons.Filled.KeyboardArrowLeft,
                onIconClick = {
                    navigateBack()
                }
            )
        },
        content = { innerPadding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 24.dp)
            ) {

                Spacer(modifier = Modifier.weight(1F))

                Image(
                    painter = painterResource(R.drawable.award),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                )

                HorizontalSpacer()

                TextTitle(
                    text = stringResource(R.string.congratulations),
                    textStyle = AppTheme.typography.h4,
                    textColor = AppTheme.colors.black
                )

                HorizontalSpacer()

                TextTitle(
                    text = stringResource(R.string.please_login),
                    textStyle = AppTheme.typography.bodyL,
                    textColor = AppTheme.colors.grayMedium
                )

                Spacer(modifier = Modifier.weight(1F))

                TextButton(
                    text = stringResource(R.string.continue_title),
                    modifier = Modifier.fillMaxWidth(),
                    onClick = navigateToNextScreen
                )

                HorizontalSpacer()
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ChooseLanguageFinalScreenPreview() {
    AppTheme {
        ChooseLanguageFinalScreen()
    }
}