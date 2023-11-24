package com.example.awesomelanguagelearning.home.ui.views.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.TextTitle
import com.example.awesomelanguagelearning.home.ui.models.CourseData

@Composable
fun CourseCard(
    courseData: CourseData,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(
                color = getBackgroundColor(courseData.isSelected),
                shape = AppTheme.shapes.medium
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressbarWithTitle(
            number = courseData.completedClasses,
            maxNumber = courseData.classesQuantity,
            isSelected = courseData.isSelected
        )

        TextTitle(
            modifier = Modifier.align(Alignment.Start),
            text = courseData.name,
            textStyle = AppTheme.typography.bodyBoldL,
            textColor = getTextColor(courseData.isSelected)
        )

        TextTitle(
            text = stringResource(
                R.string.course_description,
                courseData.classesQuantity,
                courseData.difficulty
            ),
            textColor = getTextColor(courseData.isSelected)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CourseCardPreview() {
    AppTheme {
        CourseCard(
            CourseData(
                name = "German\nLanguage",
                difficulty = "Easy",
                classesQuantity = 20,
                completedClasses = 15
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SelectedCourseCardPreview() {
    AppTheme {
        CourseCard(
            CourseData(
                name = "German\nLanguage",
                difficulty = "Easy",
                classesQuantity = 20,
                completedClasses = 15,
                isSelected = true
            )
        )
    }
}

@Composable
private fun getTextColor(isSelected: Boolean): Color =
    if (isSelected) AppTheme.colors.white else AppTheme.colors.black

@Composable
private fun getBackgroundColor(isSelected: Boolean): Color =
    if (isSelected) AppTheme.colors.blueDark else AppTheme.colors.orange.copy(alpha = 0.2f)