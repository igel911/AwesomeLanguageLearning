package com.example.awesomelanguagelearning.login_signup.ui.sign_up

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
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
import com.example.awesomelanguagelearning.core.ui.views.TextInputWithTitle
import com.example.awesomelanguagelearning.core.ui.views.TextTitle
import com.example.awesomelanguagelearning.core.ui.views.Toolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateAccountScreen(
    signupUserState: User,
    navigateToNextScreen: () -> Unit = {},
    goToLogin: () -> Unit = {},
    doLoginByFacebook: () -> Unit = {},
    doLoginByGoogle: () -> Unit = {},
    navigateBack: () -> Unit = {},
    updateEmail: (String) -> Unit = {},
    updateFirstName: (String) -> Unit = {},
    updateLastName: (String) -> Unit = {}
) {

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
                    value = signupUserState.firstName,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    onValueChange = updateFirstName,
                    labelText = stringResource(R.string.first_name)
                )

                HorizontalSpacer()

                TextInputWithTitle(
                    value = signupUserState.lastName,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    onValueChange = updateLastName,
                    labelText = stringResource(R.string.last_name)
                )

                HorizontalSpacer()

                TextInputWithTitle(
                    value = signupUserState.email,
                    modifier = Modifier.padding(horizontal = 24.dp),
                    onValueChange = updateEmail,
                    labelText = stringResource(R.string.email_address_title)
                )

                HorizontalSpacer(32)

                Controls(
                    buttonText = stringResource(R.string.continue_title),
                    regularText = stringResource(R.string.already_member),
                    clickableText = stringResource(R.string.login_title),
                    onButtonClick = navigateToNextScreen,
                    isButtonEnabled = signupUserState.isUserDataCorrect,
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
        CreateAccountScreen(
            User(
                firstName = "James",
                lastName = "Hunt",
                email = "my@mail.com"
            )
        )
    }
}