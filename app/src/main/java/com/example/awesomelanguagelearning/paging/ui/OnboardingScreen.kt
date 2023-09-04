package com.example.awesomelanguagelearning.paging.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.paging.ui.views.OnboardingPage

const val PAGE_COUNT = 3

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen() {
    Box {
        val pagerState = rememberPagerState { PAGE_COUNT }
        val viewModel = viewModel<OnboardingViewModel>()

        val currentPage by viewModel.currentPageState.collectAsState()
        LaunchedEffect(currentPage) {
            pagerState.animateScrollToPage(currentPage)
        }

        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerState
        ) { page ->
            OnboardingPage(
                pageCount = PAGE_COUNT,
                currentPage = page,
                onPinClick = { selectedPinIndex ->
                    viewModel.updateCurrentPage(selectedPinIndex)
                },
                onChooseLanguageClick = { },
                onLoginClick = { }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    AppTheme {
        OnboardingScreen()
    }
}