package com.example.awesomelanguagelearning.login_signup.ui.sign_up

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.flowWithLifecycle
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.Controls
import com.example.awesomelanguagelearning.core.ui.views.HorizontalSpacer
import com.example.awesomelanguagelearning.core.ui.views.PasswordInputWithTitle
import com.example.awesomelanguagelearning.core.ui.views.TextTitle
import com.example.awesomelanguagelearning.core.ui.views.Toolbar
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@Composable
fun ConfirmPasswordScreen(
    navigateToNextScreen: () -> Unit = {},
    goToLogin: () -> Unit = {},
    doLoginByFacebook: () -> Unit = {},
    doLoginByGoogle: () -> Unit = {},
    navigateBack: () -> Unit = {}
) {
    val viewModel: ConfirmPasswordViewModel = koinViewModel()
    val confirmPasswordState by viewModel.confirmPasswordStateFlow.collectAsState()
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(lifecycleOwner) {
        viewModel.confirmPasswordFlow
            .flowWithLifecycle(lifecycleOwner.lifecycle)
            .collectLatest {
                navigateToNextScreen()
            }
    }

    ConfirmPasswordContent(
        state = confirmPasswordState,
        onToolbarIconClick = navigateBack,
        updatePassword = viewModel::updatePassword,
        updateConfirmPassword = viewModel::updateConfirmPassword,
        onButtonClick = viewModel::doSignup,
        onClickableTextClick = goToLogin,
        onFacebookClick = doLoginByFacebook,
        onGoogleClick = doLoginByGoogle
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmPasswordContent(
    state: ConfirmPasswordState,
    onToolbarIconClick: () -> Unit = {},
    updatePassword: (String) -> Unit = {},
    updateConfirmPassword: (String) -> Unit = {},
    onButtonClick: () -> Unit = {},
    onClickableTextClick: () -> Unit = {},
    onFacebookClick: () -> Unit = {},
    onGoogleClick: () -> Unit = {}
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Toolbar(
                text = stringResource(R.string.signup_title),
                icon = Icons.Filled.KeyboardArrowLeft,
                onIconClick = onToolbarIconClick
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                HorizontalSpacer(40)

                TextTitle(
                    text = stringResource(R.string.choose_pass),
                    modifier = Modifier.padding(horizontal = 56.dp),
                    textStyle = AppTheme.typography.h5,
                    textAlign = TextAlign.Center
                )

                HorizontalSpacer()

                PasswordInputWithTitle(
                    value = state.password,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    onValueChange = updatePassword
                )

                HorizontalSpacer()

                PasswordInputWithTitle(
                    value = state.confirmPassword,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    onValueChange = updateConfirmPassword,
                    titleText = stringResource(R.string.confirm_password)
                )

                HorizontalSpacer(140)

                Controls(
                    buttonText = stringResource(R.string.signup_title),
                    regularText = stringResource(R.string.already_member),
                    clickableText = stringResource(R.string.login_title),
                    onButtonClick = onButtonClick,
                    isButtonEnabled = state.isCredentialsCorrect,
                    onClickableTextClick = onClickableTextClick,
                    onFacebookClick = onFacebookClick,
                    onGoogleClick = onGoogleClick
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ConfirmPasswordPreview() {
    AppTheme {
        ConfirmPasswordContent(ConfirmPasswordState())
    }
}