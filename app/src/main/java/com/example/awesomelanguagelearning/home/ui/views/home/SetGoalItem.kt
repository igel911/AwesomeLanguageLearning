package com.example.awesomelanguagelearning.home.ui.views.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.TextTitle

@Composable
fun SetGoalItem(
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier
        .background(
            color = AppTheme.colors.orangeLight,
            shape = AppTheme.shapes.medium
        )
        .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_pfp),
            contentDescription = ""
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.Start
        ) {
            TextTitle(
                text = stringResource(R.string.set_goal),
                textStyle = AppTheme.typography.bodyBoldL
            )

            TextTitle(
                text = stringResource(R.string.who_set_goal)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SetGoalItemPreview() {
    AppTheme {
        SetGoalItem()
    }
}