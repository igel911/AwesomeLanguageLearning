package com.example.awesomelanguagelearning.home.ui.views.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Timer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.TextTitle
import com.example.awesomelanguagelearning.core.ui.views.TextTitleLeadingIcon
import com.example.awesomelanguagelearning.home.ui.models.FeaturedCourseData

@Composable
fun FeaturedCourseCard(
    featuredCourseData: FeaturedCourseData,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier
        .background(
            color = getBackgroundColor(featuredCourseData.isSelected),
            shape = AppTheme.shapes.medium
        )
        .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(40.dp)
        ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.Start
        ) {
            TextTitle(
                text = featuredCourseData.name,
                textStyle = AppTheme.typography.bodyBoldL
            )

            TextTitle(
                text = featuredCourseData.type
            )

            TextTitleLeadingIcon(
                text = stringResource(R.string.hours, featuredCourseData.duration),
                imageVector = Icons.Filled.Timer,
                imageColor = AppTheme.colors.greenDark
            )
        }

        Image(
            painter = painterResource(R.drawable.paging_1),
            contentDescription = ""
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeListTitlePreview() {
    AppTheme {
        FeaturedCourseCard(
            FeaturedCourseData(
                name = stringResource(R.string.german_language),
                type = stringResource(R.string.grammar_quiz),
                duration = 2
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeListTitleSelectedPreview() {
    AppTheme {
        FeaturedCourseCard(
            FeaturedCourseData(
                name = stringResource(R.string.german_language),
                type = stringResource(R.string.grammar_quiz),
                duration = 2,
                isSelected = true
            )
        )
    }
}

@Composable
private fun getBackgroundColor(isSelected: Boolean): Color =
    if (isSelected) AppTheme.colors.blueLight else AppTheme.colors.orangeLight