package com.example.awesomelanguagelearning.paging.ui.views

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.HorizontalSpacer
import com.example.awesomelanguagelearning.core.ui.views.TextButton
import com.example.awesomelanguagelearning.core.ui.views.TextTitle
import com.example.awesomelanguagelearning.core.ui.views.TextWithClickablePart

@Composable
fun OnboardingPage(
    pageCount: Int,
    currentPage: Int,
    onPinClick: (Int) -> Unit = { },
    onChooseLanguageClick: () -> Unit = { },
    onLoginClick: () -> Unit = { }
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier.weight(1F),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painterResource(getImage(currentPage)),
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .padding(horizontal = 50.dp)
                    .fillMaxWidth()
            )
        }

        Row(
            Modifier.padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(pageCount) { iteration ->
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(getPinColor(currentPage, iteration))
                        .size(12.dp)
                        .clickable { onPinClick(iteration) }
                )
            }
        }

        HorizontalSpacer(40)

        TextTitle(
            text = stringResource(getTitleText(currentPage)),
            textStyle = AppTheme.typography.h5,
            textColor = AppTheme.colors.black
        )

        HorizontalSpacer(10)

        TextTitle(
            text = stringResource(getDescriptionText(currentPage)),
            modifier = Modifier.width(245.dp),
            textStyle = AppTheme.typography.bodyM,
            textColor = AppTheme.colors.grayMedium,
            textAlign = TextAlign.Center
        )

        HorizontalSpacer(50)

        TextButton(
            text = stringResource(R.string.choose_language),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) { onChooseLanguageClick() }

        HorizontalSpacer(32)

        TextWithClickablePart(
            regularText = stringResource(R.string.already_user),
            clickableText = stringResource(R.string.login),
            modifier = Modifier.padding(bottom = 48.dp),
            onClick = onLoginClick
        )
    }
}

@Composable
private fun getPinColor(
    currentPage: Int,
    iteration: Int
) = if (currentPage == iteration) AppTheme.colors.blueDark else AppTheme.colors.grayMedium

@DrawableRes
private fun getImage(currentPage: Int): Int =
    when (currentPage) {
        0 -> R.drawable.paging_1
        1 -> R.drawable.paging_2
        else -> R.drawable.paging_3
    }

@StringRes
private fun getTitleText(currentPage: Int): Int =
    when (currentPage) {
        0 -> R.string.confidence_words
        1 -> R.string.time_learn
        else -> R.string.lessons_need
    }


@StringRes
private fun getDescriptionText(currentPage: Int): Int =
    when (currentPage) {
        0 -> R.string.with_conversation
        1 -> R.string.develop_habit
        else -> R.string.using_variety
    }

@Preview(showBackground = true)
@Composable
fun PagePreview() {
    AppTheme {
        OnboardingPage(
            pageCount = 3,
            currentPage = 1
        )
    }
}