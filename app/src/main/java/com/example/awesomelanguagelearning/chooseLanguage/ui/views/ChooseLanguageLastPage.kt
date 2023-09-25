package com.example.awesomelanguagelearning.chooseLanguage.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun ChooseLanguageLastPage(
    state: ChooseLanguagePageState,
    onNextClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalSpacer()

        TextTitle(
            text = state.title,
            textStyle = AppTheme.typography.h5,
            modifier = Modifier.align(Alignment.Start)
        )

        HorizontalSpacer()

        TextTitle(
            text = state.subTitle,
            textStyle = AppTheme.typography.bodyL,
            textColor = AppTheme.colors.grayMedium,
            modifier = Modifier.align(Alignment.Start)
        )

        HorizontalSpacer(48)

        TextTitle(
            text = stringResource(R.string.course_content),
            textStyle = AppTheme.typography.h5,
            modifier = Modifier.align(Alignment.Start)
        )

        HorizontalSpacer()

        Row(
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            CourseContentItem(
                title = stringResource(R.string.words_quantity),
                subTitle = stringResource(R.string.words),
                modifier = Modifier.weight(1F)
            )

            CourseContentItem(
                title = stringResource(R.string.sentences_quantity),
                subTitle = stringResource(R.string.sentences),
                modifier = Modifier.weight(1F)
            )
        }

        Spacer(modifier = Modifier.weight(1F))

        TextButton(
            text = stringResource(R.string.next),
            modifier = Modifier.fillMaxWidth(),
            onClick = onNextClick
        )

        HorizontalSpacer()
    }
}

@Preview(showBackground = true)
@Composable
fun ChooseLanguageLastPagePreview() {
    AppTheme {
        ChooseLanguageLastPage(
            ChooseLanguagePageState(
                title = stringResource(R.string.course_overview),
                subTitle = stringResource(R.string.overview_text)
            )
        )
    }
}