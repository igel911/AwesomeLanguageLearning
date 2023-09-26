package com.example.awesomelanguagelearning.chooseLanguage.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Task
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.HorizontalSpacer
import com.example.awesomelanguagelearning.core.ui.views.TextTitle

@Composable
fun CourseContentItem(
    title: String,
    subTitle: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(
                color = AppTheme.colors.grayLight,
                shape = AppTheme.shapes.large
            )
            .padding(vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            imageVector = Icons.Filled.Task,
            contentDescription = subTitle,
            modifier = Modifier
                .size(60.dp)
                .background(
                    color = AppTheme.colors.white,
                    shape = CircleShape
                )
                .padding(10.dp)
        )

        HorizontalSpacer()

        TextTitle(
            text = title,
            textStyle = AppTheme.typography.bodyBoldS
        )

        HorizontalSpacer(12)

        TextTitle(
            text = subTitle,
            textStyle = AppTheme.typography.bodyS,
            textColor = AppTheme.colors.grayMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CourseContentItemPreview() {
    AppTheme {
        CourseContentItem(
            title = "9000+",
            subTitle = "Words"
        )
    }
}