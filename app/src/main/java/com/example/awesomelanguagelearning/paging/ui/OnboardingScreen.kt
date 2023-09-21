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
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.paging.ui.views.OnboardingPage
import org.koin.androidx.compose.koinViewModel

const val PAGE_COUNT = 3

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    onChooseLanguageClick: () -> Unit = {},
    onLoginClick: () -> Unit = {}
) {
    Box {
        val pagerState = rememberPagerState { PAGE_COUNT }
        val viewModel: OnboardingViewModel = koinViewModel()

        val currentPage by viewModel.currentPageStateFlow.collectAsState()
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
                onChooseLanguageClick = onChooseLanguageClick,
                onLoginClick = onLoginClick
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