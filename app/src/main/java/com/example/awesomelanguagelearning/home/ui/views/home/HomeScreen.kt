package com.example.awesomelanguagelearning.home.ui.views.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.home.ui.models.CourseData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val colors = AppTheme.colors

    Scaffold(
        modifier = Modifier
            .background(colors.grayLight)
            .fillMaxSize(),
        topBar = {
            HomeToolbar(
                username = "Filllo",
                onUserIconClick = { },
                onActionIconClick = { }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                HomeListTitle(
                    firstText = stringResource(id = R.string.continue_course),
                    secondText = stringResource(id = R.string.see_all),
                    modifier = Modifier.fillMaxWidth()
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    CourseCard(
                        CourseData(
                            name = "German\nLanguage",
                            difficulty = "Easy",
                            classesQuantity = 20,
                            completedClasses = 15,
                            isSelected = true
                        ),
                        modifier = Modifier.weight(1f)
                    )

                    CourseCard(
                        CourseData(
                            name = "Spanish\nLanguage",
                            difficulty = "Easy",
                            classesQuantity = 30,
                            completedClasses = 10
                        ),
                        modifier = Modifier.weight(1f)
                    )
                }

                HomeListTitle(
                    firstText = stringResource(id = R.string.featured_courses),
                    secondText = stringResource(id = R.string.see_all),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    AppTheme {
        HomeScreen()
    }
}