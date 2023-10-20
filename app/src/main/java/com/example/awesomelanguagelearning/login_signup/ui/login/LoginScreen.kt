package com.example.awesomelanguagelearning.login_signup.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.BaseComposableScreen
import com.example.awesomelanguagelearning.core.ui.views.Controls
import com.example.awesomelanguagelearning.core.ui.views.HorizontalSpacer
import com.example.awesomelanguagelearning.core.ui.views.PasswordInputWithTitle
import com.example.awesomelanguagelearning.core.ui.views.TextInputWithTitle
import com.example.awesomelanguagelearning.core.ui.views.TextTitle
import com.example.awesomelanguagelearning.core.ui.views.TextTitleClickable
import com.example.awesomelanguagelearning.core.ui.views.Toolbar
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(navController: NavController) {
    val viewModel: LoginViewModel = koinViewModel()
    val loginState by viewModel.loginStateFlow.collectAsState()

    BaseComposableScreen(
        navController = navController,
        viewModel = viewModel,
    ) {
        LoginContent(
            loginState = loginState,
            onEvent = viewModel::onEvent
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LoginContent(
    loginState: LoginState,
    onEvent: (LoginEvent) -> Unit = {}
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Toolbar(
                text = stringResource(R.string.login_title),
                icon = Icons.Filled.KeyboardArrowLeft,
                onIconClick = { onEvent(LoginEvent.NavigateBack) }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding)
                    .padding(horizontal = 24.dp, vertical = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

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
                    textStyle = AppTheme.typography.h5,
                    textAlign = TextAlign.Center
                )

                HorizontalSpacer()

                TextInputWithTitle(
                    value = loginState.email,
                    onValueChange = { onEvent(LoginEvent.UpdateField.updateEmail(it)) },
                    labelText = stringResource(R.string.email_address_title)
                )

                HorizontalSpacer()

                PasswordInputWithTitle(
                    value = loginState.password,
                    onValueChange = { onEvent(LoginEvent.UpdateField.updatePassword(it)) }
                )

                HorizontalSpacer(12)

                TextTitleClickable(
                    text = stringResource(R.string.forgot_password),
                    modifier = Modifier.align(Alignment.Start),
                    textStyle = AppTheme.typography.bodyM,
                    textColor = AppTheme.colors.red,
                    onClick = { onEvent(LoginEvent.NavigateToForgotPassword) }
                )

                HorizontalSpacer(32)

                Controls(
                    buttonText = stringResource(R.string.login_title),
                    regularText = stringResource(R.string.not_member),
                    clickableText = stringResource(R.string.signup_title),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    onButtonClick = { onEvent(LoginEvent.DoLogin) },
                    isButtonEnabled = loginState.isCredentialsCorrect,
                    onClickableTextClick = { onEvent(LoginEvent.NavigateToSignup) },
                    onFacebookClick = { onEvent(LoginEvent.LoginByFacebook) },
                    onGoogleClick = { onEvent(LoginEvent.LoginByGoogle) }
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    AppTheme {
        LoginContent(LoginState())
    }
}