package com.example.awesomelanguagelearning.login_signup.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
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
import com.example.awesomelanguagelearning.core.ui.views.TextInputWithTitle
import com.example.awesomelanguagelearning.core.ui.views.TextTitle
import com.example.awesomelanguagelearning.core.ui.views.TextTitleClickable
import com.example.awesomelanguagelearning.core.ui.views.Toolbar
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    navigateToNextScreen: () -> Unit = {},
    goToSignup: () -> Unit = {},
    doLoginByFacebook: () -> Unit = {},
    doLoginByGoogle: () -> Unit = {},
    goToForgotPassword: () -> Unit = {},
    navigateBack: () -> Unit = {}
) {
    val viewModel: LoginViewModel = koinViewModel()
    val loginState by viewModel.loginStateFlow.collectAsState()
    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(lifecycleOwner) {
        viewModel.loginResultFlow.flowWithLifecycle(lifecycleOwner.lifecycle).collectLatest {
            navigateToNextScreen()
        }
    }

    LoginContent(
        loginState = loginState,
        onToolbarIconClick = navigateBack,
        updateEmail = viewModel::updateEmail,
        updatePassword = viewModel::updatePassword,
        onButtonClick = viewModel::doLogin,
        onClickableTextClick = goToSignup,
        onFacebookClick = doLoginByFacebook,
        onGoogleClick = doLoginByGoogle,
        onForgotPasswordClick = goToForgotPassword
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginContent(
    loginState: LoginState,
    onToolbarIconClick: () -> Unit = {},
    updateEmail: (String) -> Unit = {},
    updatePassword: (String) -> Unit = {},
    onButtonClick: () -> Unit = {},
    onClickableTextClick: () -> Unit = {},
    onFacebookClick: () -> Unit = {},
    onGoogleClick: () -> Unit = {},
    onForgotPasswordClick: () -> Unit = {}
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Toolbar(
                text = stringResource(R.string.login_title),
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

                HorizontalSpacer()

                Image(
                    painterResource(R.drawable.login_logo),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(105.dp)
                        .height(82.dp)
                )

                HorizontalSpacer(12)

                TextTitle(
                    text = stringResource(R.string.for_free),
                    modifier = Modifier.padding(horizontal = 56.dp),
                    textStyle = AppTheme.typography.h5,
                    textAlign = TextAlign.Center
                )

                HorizontalSpacer()

                TextInputWithTitle(
                    value = loginState.email,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    onValueChange = updateEmail,
                    labelText = stringResource(R.string.email_address_title)
                )

                HorizontalSpacer()

                PasswordInputWithTitle(
                    value = loginState.password,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    onValueChange = updatePassword
                )

                HorizontalSpacer(12)

                TextTitleClickable(
                    text = stringResource(R.string.forgot_password),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 24.dp),
                    textStyle = AppTheme.typography.bodyM,
                    textColor = AppTheme.colors.red,
                    onClick = onForgotPasswordClick
                )

                HorizontalSpacer(32)

                Controls(
                    buttonText = stringResource(R.string.login_title),
                    regularText = stringResource(R.string.not_member),
                    clickableText = stringResource(R.string.signup_title),
                    onButtonClick = onButtonClick,
                    isButtonEnabled = loginState.isCredentialsCorrect,
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
fun LoginScreenPreview() {
    AppTheme {
        LoginContent(LoginState())
    }
}