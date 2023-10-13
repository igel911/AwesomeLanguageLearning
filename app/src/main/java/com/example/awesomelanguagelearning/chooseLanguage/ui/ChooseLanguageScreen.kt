package com.example.awesomelanguagelearning.chooseLanguage.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.chooseLanguage.ui.views.ChooseLanguageLastPage
import com.example.awesomelanguagelearning.chooseLanguage.ui.views.ChooseLanguagePage
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.Toolbar
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ChooseLanguageScreen(
    navigateToNextScreen: () -> Unit = {},
    navigateBack: () -> Unit = {}
) {

    val viewModel: ChooseLanguageViewModel = koinViewModel()

    val state by viewModel.state.collectAsState()
    val pagerSize = state.pages.size
    val currentPageIndex = state.currentPage
    val pagerState = rememberPagerState { pagerSize }

    LaunchedEffect(currentPageIndex) {
        pagerState.animateScrollToPage(currentPageIndex)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Toolbar(
                text = stringResource(R.string.complited_title, currentPageIndex + 1, pagerSize),
                icon = Icons.Filled.KeyboardArrowLeft,
                onIconClick = {
                    if (currentPageIndex == 0) navigateBack() else viewModel.onBack()
                }
            )
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
            ) {
                HorizontalPager(
                    modifier = Modifier.fillMaxSize(),
                    state = pagerState,
                    userScrollEnabled = false
                ) { pageIndex ->
                    val pageState = state.pages[pageIndex]
                    if (pageState.isLast) {
                        ChooseLanguageLastPage(
                            state = pageState,
                            onNextClick = navigateToNextScreen
                        )
                    } else {
                        ChooseLanguagePage(
                            state = pageState,
                            onNextClick = viewModel::onNext,
                            onItemClick = viewModel::onListItemClick
                        )
                    }
                }
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