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
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.Controls
import com.example.awesomelanguagelearning.core.ui.views.HorizontalSpacer
import com.example.awesomelanguagelearning.core.ui.views.TextInputWithTitle
import com.example.awesomelanguagelearning.core.ui.views.TextTitle
import com.example.awesomelanguagelearning.core.ui.views.Toolbar
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateAccountScreen(
    navigateToNextScreen: () -> Unit = {},
    goToLogin: () -> Unit = {},
    doLoginByFacebook: () -> Unit = {},
    doLoginByGoogle: () -> Unit = {},
    navigateBack: () -> Unit = {}
) {
    val viewModel: CreateAccountViewModel = koinViewModel()
    val signupState by viewModel.createAccountStateFlow.collectAsState()
    val nextScreenState by viewModel.createAccountResultFlow.collectAsState(initial = false)
    if (nextScreenState) {
        navigateToNextScreen()
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Toolbar(
                text = stringResource(R.string.signup_title),
                icon = Icons.Filled.KeyboardArrowLeft,
                onIconClick = navigateBack
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
                    text = stringResource(R.string.create_acc),
                    modifier = Modifier.padding(horizontal = 56.dp),
                    textStyle = AppTheme.typography.h5,
                    textAlign = TextAlign.Center
                )

                HorizontalSpacer()

                TextInputWithTitle(
                    value = signupState.firstName,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    onValueChange = viewModel::updateFirstName,
                    labelText = stringResource(R.string.first_name)
                )

                HorizontalSpacer()

                TextInputWithTitle(
                    value = signupState.lastName,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    onValueChange = viewModel::updateLastName,
                    labelText = stringResource(R.string.last_name)
                )

                HorizontalSpacer()

                TextInputWithTitle(
                    value = signupState.email,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    onValueChange = viewModel::updateEmail,
                    labelText = stringResource(R.string.email_address_title)
                )

                HorizontalSpacer(32)

                Controls(
                    buttonText = stringResource(R.string.continue_title),
                    regularText = stringResource(R.string.already_member),
                    clickableText = stringResource(R.string.login_title),
                    onButtonClick = viewModel::continueSignup,
                    onClickableTextClick = goToLogin,
                    onFacebookClick = doLoginByFacebook,
                    onGoogleClick = doLoginByGoogle
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CreateAccountPreview() {
    AppTheme {
        CreateAccountScreen()
    }
}