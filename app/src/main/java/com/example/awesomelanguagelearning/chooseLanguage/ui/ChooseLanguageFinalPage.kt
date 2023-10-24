package com.example.awesomelanguagelearning.chooseLanguage.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.chooseLanguage.domain.entity.ChooseLanguagePageState
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.HorizontalSpacer
import com.example.awesomelanguagelearning.core.ui.views.TextButton
import com.example.awesomelanguagelearning.core.ui.views.TextTitle

@Composable
fun ChooseLanguageFinalPage(
    state: ChooseLanguagePageState,
    modifier: Modifier = Modifier,
    onEvent: (ChooseLanguageEvent) -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
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
            text = state.title,
            textStyle = AppTheme.typography.h4,
            textColor = AppTheme.colors.black
        )

        HorizontalSpacer()

        TextTitle(
            text = state.subTitle,
            textStyle = AppTheme.typography.bodyL,
            textColor = AppTheme.colors.grayMedium
        )

        Spacer(modifier = Modifier.weight(1F))

        TextButton(
            text = stringResource(R.string.continue_title),
            modifier = Modifier.fillMaxWidth(),
            onClick = { onEvent(ChooseLanguageEvent.FinishFlow) }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ChooseLanguageFinalScreenPreview() {
    AppTheme {
        ChooseLanguageFinalPage(
            ChooseLanguagePageState(
                title = stringResource(R.string.congratulations),
                subTitle = stringResource(R.string.please_login)
            )
        )
    }
}