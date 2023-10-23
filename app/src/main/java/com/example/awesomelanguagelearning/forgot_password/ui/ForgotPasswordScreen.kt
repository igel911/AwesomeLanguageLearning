package com.example.awesomelanguagelearning.forgot_password.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavController
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.theme.AppTheme
import com.example.awesomelanguagelearning.core.ui.views.BaseComposableScreen
import com.example.awesomelanguagelearning.core.ui.views.TextButton
import com.example.awesomelanguagelearning.core.ui.views.TextInputWithTitle
import com.example.awesomelanguagelearning.core.ui.views.Toolbar
import com.example.awesomelanguagelearning.forgot_password.ui.models.ForgotPasswordState
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@Composable
fun ForgotPasswordScreen(navController: NavController) {

    val viewModel: ForgotPasswordViewModel = koinViewModel()
    val emailState by viewModel.emailStateFlow.collectAsState()
    val lifecycleOwner = LocalLifecycleOwner.current
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.forgotPasswordErrorState.flowWithLifecycle(lifecycleOwner.lifecycle)
            .collectLatest { resultText ->
                snackbarHostState.showSnackbar(resultText)
            }
    }

    BaseComposableScreen(
        navController = navController,
        viewModel = viewModel,
    ) {
        ForgotPasswordContent(
            state = emailState,
            hostState = snackbarHostState,
            onEvent = viewModel::onEvent
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ForgotPasswordContent(
    state: ForgotPasswordState,
    hostState: SnackbarHostState,
    onEvent: (ForgotPasswordEvent) -> Unit = {}
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Toolbar(
                text = stringResource(R.string.forgot_password),
                icon = Icons.Filled.KeyboardArrowLeft,
                onIconClick = { onEvent(ForgotPasswordEvent.NavigateBack) }
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = hostState)
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 24.dp, vertical = 100.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                TextInputWithTitle(
                    value = state.email,
                    onValueChange = { onEvent(ForgotPasswordEvent.UpdateEmail(it)) },
                    labelText = stringResource(R.string.forgot_password_title)
                )

                Spacer(modifier = Modifier.weight(1F))

                TextButton(
                    text = stringResource(R.string.send_code),
                    isButtonEnabled = state.isButtonEnabled,
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onEvent(ForgotPasswordEvent.DoPasswordRestore) }
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ForgotPasswordContentPreview() {
    AppTheme {
        ForgotPasswordContent(
            state = ForgotPasswordState(
                email = "some@mail.com",
                isButtonEnabled = true
            ),
            hostState = SnackbarHostState()
        )
    }
}