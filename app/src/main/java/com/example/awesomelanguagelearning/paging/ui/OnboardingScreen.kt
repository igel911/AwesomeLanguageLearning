package com.example.awesomelanguagelearning.paging.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.BaseComposableScreen
import com.example.awesomelanguagelearning.paging.ui.views.OnboardingPage
import org.koin.androidx.compose.koinViewModel

const val PAGE_COUNT = 3

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(navController: NavController) {

    val viewModel: OnboardingViewModel = koinViewModel()
    val pagerState = rememberPagerState { PAGE_COUNT }
    val currentPage by viewModel.currentPageStateFlow.collectAsState()

    LaunchedEffect(currentPage) {
        pagerState.animateScrollToPage(currentPage)
    }

    BaseComposableScreen(
        navController = navController,
        viewModel = viewModel,
    ) {
        OnboardingContent(
            pagerState = pagerState,
            onEvent = viewModel::onEvent
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun OnboardingContent(
    pagerState: PagerState,
    onEvent: (OnboardingEvent) -> Unit = {}
) {
    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        state = pagerState
    ) { page ->
        OnboardingPage(
            pageCount = PAGE_COUNT,
            currentPage = page,
            onEvent = onEvent
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
private fun OnboardingScreenPreview() {
    AppTheme {
        OnboardingContent(pagerState = rememberPagerState { PAGE_COUNT })
    }
}