package com.example.awesomelanguagelearning.login_signup.ui.sign_up

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.HorizontalSpacer
import com.example.awesomelanguagelearning.core.ui.views.PasswordInputWithTitle
import com.example.awesomelanguagelearning.core.ui.views.TextTitle
import com.example.awesomelanguagelearning.core.ui.views.Toolbar
import com.example.awesomelanguagelearning.login_signup.ui.Controls

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmPasswordScreen() {
    val viewModel = viewModel { ConfirmPasswordViewModel() }
    val confirmPasswordState by viewModel.confirmPasswordStateFlow.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Toolbar(
                text = stringResource(R.string.signup_title),
                icon = Icons.Filled.KeyboardArrowLeft,
                onIconClick = { }
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
                    value = confirmPasswordState.password,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    onValueChange = viewModel::updatePassword
                )

                HorizontalSpacer()

                PasswordInputWithTitle(
                    value = confirmPasswordState.confirmPassword,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    onValueChange = viewModel::updateConfirmPassword,
                    titleText = stringResource(R.string.confirm_password)
                )

                HorizontalSpacer(140)

                Controls(
                    buttonText = stringResource(R.string.signup_title),
                    regularText = stringResource(R.string.already_member),
                    clickableText = stringResource(R.string.login_title),
                    onButtonClick = viewModel::doSignup,
                    onClickableTextClick = viewModel::goToLogin,
                    onFacebookClick = viewModel::doLoginByFacebook,
                    onGoogleClick = viewModel::doLoginByGoogle
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ConfirmPasswordPreview() {
    AppTheme {
        ConfirmPasswordScreen()
    }
}