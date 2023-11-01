package com.example.awesomelanguagelearning.login_signup.ui.sign_up

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.domain.models.User
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.Controls
import com.example.awesomelanguagelearning.core.ui.views.HorizontalSpacer
import com.example.awesomelanguagelearning.core.ui.views.PasswordInputWithTitle
import com.example.awesomelanguagelearning.core.ui.views.TextTitle
import com.example.awesomelanguagelearning.core.ui.views.Toolbar
import com.example.awesomelanguagelearning.login_signup.ui.validator.ConfirmPasswordValidationResult

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmPasswordScreen(
    signupUser: User,
    snackbarHostState: SnackbarHostState,
    validationResult: ConfirmPasswordValidationResult,
    onEvent: (SignupEvent) -> Unit = {}
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Toolbar(
                text = stringResource(R.string.signup_title),
                icon = Icons.Filled.KeyboardArrowLeft,
                onIconClick = { onEvent(SignupEvent.NavigateBack) }
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding)
                    .padding(horizontal = 24.dp, vertical = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                TextTitle(
                    text = stringResource(R.string.choose_pass),
                    textStyle = AppTheme.typography.h5,
                    textAlign = TextAlign.Center
                )

                HorizontalSpacer()

                PasswordInputWithTitle(
                    value = signupUser.password,
                    onValueChange = { onEvent(SignupEvent.UpdateField.updatePassword(it)) },
                    validationResult = validationResult.passwordValidationResult
                )

                HorizontalSpacer()

                PasswordInputWithTitle(
                    value = signupUser.confirmPassword,
                    onValueChange = { onEvent(SignupEvent.UpdateField.updateConfirmPassword(it)) },
                    titleText = stringResource(R.string.confirm_password),
                    validationResult = validationResult.repeatedPasswordValidationResult
                )

                HorizontalSpacer(140)

                Controls(
                    buttonText = stringResource(R.string.signup_title),
                    regularText = stringResource(R.string.already_member),
                    clickableText = stringResource(R.string.login_title),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    onButtonClick = { onEvent(SignupEvent.DoSignup) },
                    onClickableTextClick = { onEvent(SignupEvent.NavigateToLogin) },
                    onFacebookClick = { onEvent(SignupEvent.LoginByFacebook) },
                    onGoogleClick = { onEvent(SignupEvent.LoginByGoogle) }
                )
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
private fun ConfirmPasswordPreview() {
    AppTheme {
        ConfirmPasswordScreen(
            signupUser = User(),
            snackbarHostState = SnackbarHostState(),
            validationResult = ConfirmPasswordValidationResult.valid()
        )
    }
}