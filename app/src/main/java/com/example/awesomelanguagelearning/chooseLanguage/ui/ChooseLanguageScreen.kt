package com.example.awesomelanguagelearning.chooseLanguage.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
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
import androidx.navigation.NavController
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.chooseLanguage.domain.entity.ChooseLanguageState
import com.example.awesomelanguagelearning.chooseLanguage.ui.views.ChooseLanguageOverviewPage
import com.example.awesomelanguagelearning.chooseLanguage.ui.views.ChooseLanguagePage
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.BaseComposableScreen
import com.example.awesomelanguagelearning.core.ui.views.Toolbar
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChooseLanguageScreen(navController: NavController) {

    val viewModel: ChooseLanguageViewModel = koinViewModel()

    val state by viewModel.state.collectAsState()
    val currentPageIndex = state.currentPage
    val pagerState = rememberPagerState { state.pages.size }

    LaunchedEffect(currentPageIndex) {
        pagerState.animateScrollToPage(currentPageIndex)
    }

    BaseComposableScreen(
        navController = navController,
        viewModel = viewModel,
    ) {
        ChooseLanguageContent(
            pagerState = pagerState,
            screenState = state,
            onEvent = viewModel::onEvent
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
private fun ChooseLanguageContent(
    pagerState: PagerState,
    screenState: ChooseLanguageState,
    onEvent: (ChooseLanguageEvent) -> Unit = {}
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Toolbar(
                text = getCorrectTitle(screenState),
                icon = Icons.Filled.KeyboardArrowLeft,
                onIconClick = { onEvent(ChooseLanguageEvent.NavigateBack) }
            )
        },
        content = { innerPadding ->
            val pageModifier = Modifier
                .fillMaxSize()
                .padding(vertical = 24.dp)

            HorizontalPager(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
                    .fillMaxSize(),
                state = pagerState,
                userScrollEnabled = false
            ) { pageIndex ->
                val pageState = screenState.pages[pageIndex]
                when {
                    pageState.isLast -> {
                        ChooseLanguageFinalPage(
                            state = pageState,
                            onEvent = onEvent,
                            modifier = pageModifier
                        )
                    }

                    pageState.isOverview -> {
                        ChooseLanguageOverviewPage(
                            state = pageState,
                            onEvent = onEvent,
                            modifier = pageModifier
                        )
                    }

                    else -> {
                        ChooseLanguagePage(
                            state = pageState,
                            onEvent = onEvent,
                            modifier = pageModifier
                        )
                    }
                }
            }
        }
    )
}

@Composable
private fun getCorrectTitle(screenState: ChooseLanguageState): String =
    if (screenState.isToolbarTitleVisible) {
        stringResource(
            R.string.complited_title,
            screenState.getCurrentPageForTitle(),
            screenState.getPageQuantityForTitle()
        )
    } else ""

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
private fun ChooseLanguageScreenPreview() {
    AppTheme {
        ChooseLanguageContent(
            pagerState = rememberPagerState { 7 },
            screenState = ChooseLanguageState()
        )
    }
}