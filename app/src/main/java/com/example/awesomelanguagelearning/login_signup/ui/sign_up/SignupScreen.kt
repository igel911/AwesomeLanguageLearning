package com.example.awesomelanguagelearning.login_signup.ui.sign_up

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavController
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.BaseComposableScreen
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SignupScreen(navController: NavController) {

    val viewModel: SignupViewModel = koinViewModel()

    val state by viewModel.state.collectAsState()
    val currentPageIndex = state.currentPage
    val pagerState = rememberPagerState { state.pageQuantity }
    val snackbarHostState = remember { SnackbarHostState() }
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(currentPageIndex) {
        pagerState.animateScrollToPage(currentPageIndex)
    }

    LaunchedEffect(Unit) {
        viewModel.signupResultFlow
            .flowWithLifecycle(lifecycleOwner.lifecycle)
            .collectLatest { signupResult ->
                if (!signupResult.isSuccessful) {
                    snackbarHostState.showSnackbar(signupResult.errorMessage.orEmpty())
                }
            }
    }

    BaseComposableScreen(
        navController = navController,
        viewModel = viewModel,
    ) {
        SignupContent(
            pagerState = pagerState,
            screenState = state,
            snackbarHostState = snackbarHostState,
            onEvent = viewModel::onEvent
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SignupContent(
    pagerState: PagerState,
    screenState: SignupScreenState,
    snackbarHostState: SnackbarHostState = SnackbarHostState(),
    onEvent: (SignupEvent) -> Unit = {}
) {
    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        state = pagerState,
        userScrollEnabled = false
    ) { pageIndex ->
        if (pageIndex == 0) {
            CreateAccountScreen(
                signupUserState = screenState.user,
                onEvent = onEvent,
                validationResult = screenState.createAccountValidationResult
            )
        } else {
            ConfirmPasswordScreen(
                signupUser = screenState.user,
                snackbarHostState = snackbarHostState,
                onEvent = onEvent,
                validationResult = screenState.confirmPasswordValidationResult
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
private fun SignupScreenPreview() {
    AppTheme {
        SignupContent(
            pagerState = rememberPagerState { 2 },
            screenState = SignupScreenState()
        )
    }
}