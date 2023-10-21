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
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SignupScreen(
    navigateToNextScreen: () -> Unit = {},
    goToLogin: () -> Unit = {},
    doLoginByFacebook: () -> Unit = {},
    doLoginByGoogle: () -> Unit = {},
    navigateBack: () -> Unit = {}
) {

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
                if (signupResult.isSuccessful) {
                    navigateToNextScreen()
                } else {
                    snackbarHostState.showSnackbar("Something went wrong:(")
                }
            }
    }

    SignupContent(
        pagerState = pagerState,
        screenState = state,
        snackbarHostState = snackbarHostState,
        navigateToNextScreen = viewModel::onNext,
        navigateToNextFlow = viewModel::doSignup,
        goToLogin = goToLogin,
        doLoginByFacebook = doLoginByFacebook,
        doLoginByGoogle = doLoginByGoogle,
        navigateBack = navigateBack,
        navigateBackVM = viewModel::onBack,
        updateEmail = viewModel::updateEmail,
        updateFirstName = viewModel::updateFirstName,
        updateLastName = viewModel::updateLastName,
        updatePassword = viewModel::updatePassword,
        updateConfirmPassword = viewModel::updateConfirmPassword
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SignupContent(
    pagerState: PagerState,
    screenState: SignupScreenState,
    snackbarHostState: SnackbarHostState = SnackbarHostState(),
    navigateToNextScreen: () -> Unit = {},
    navigateToNextFlow: () -> Unit = {},
    goToLogin: () -> Unit = {},
    doLoginByFacebook: () -> Unit = {},
    doLoginByGoogle: () -> Unit = {},
    navigateBack: () -> Unit = {},
    navigateBackVM: () -> Unit = {},
    updateEmail: (String) -> Unit = {},
    updateFirstName: (String) -> Unit = {},
    updateLastName: (String) -> Unit = {},
    updatePassword: (String) -> Unit = {},
    updateConfirmPassword: (String) -> Unit = {}
) {
    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        state = pagerState,
        userScrollEnabled = false
    ) { pageIndex ->
        if (pageIndex == 0) {
            CreateAccountScreen(
                signupUserState = screenState.user,
                navigateToNextScreen = navigateToNextScreen,
                goToLogin = goToLogin,
                doLoginByFacebook = doLoginByFacebook,
                doLoginByGoogle = doLoginByGoogle,
                navigateBack = navigateBack,
                updateEmail = updateEmail,
                updateFirstName = updateFirstName,
                updateLastName = updateLastName
            )
        } else {
            ConfirmPasswordScreen(
                signupUser = screenState.user,
                snackbarHostState = snackbarHostState,
                navigateToNextScreen = navigateToNextFlow,
                goToLogin = goToLogin,
                doLoginByFacebook = doLoginByFacebook,
                doLoginByGoogle = doLoginByGoogle,
                navigateBack = navigateBackVM,
                updatePassword = updatePassword,
                updateConfirmPassword = updateConfirmPassword
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