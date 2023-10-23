package com.example.awesomelanguagelearning.login_signup.ui.login

import com.example.awesomelanguagelearning.core.ui.models.BaseEffect
import com.example.awesomelanguagelearning.core.ui.navigation.AppNavigation
import com.example.awesomelanguagelearning.core.ui.viewmodels.NavigationViewModel
import com.example.awesomelanguagelearning.login_signup.ui.login.LoginEvent.DoLogin
import com.example.awesomelanguagelearning.login_signup.ui.login.LoginEvent.LoginByFacebook
import com.example.awesomelanguagelearning.login_signup.ui.login.LoginEvent.LoginByGoogle
import com.example.awesomelanguagelearning.login_signup.ui.login.LoginEvent.NavigateBack
import com.example.awesomelanguagelearning.login_signup.ui.login.LoginEvent.NavigateToForgotPassword
import com.example.awesomelanguagelearning.login_signup.ui.login.LoginEvent.NavigateToSignup
import com.example.awesomelanguagelearning.login_signup.ui.login.LoginEvent.UpdateField
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : NavigationViewModel() {
    private val _loginStateFlow = MutableStateFlow(LoginState())
    val loginStateFlow = _loginStateFlow.asStateFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            DoLogin -> doLogin()

            LoginByFacebook -> {}

            LoginByGoogle -> {}

            NavigateToSignup -> navigateTo(AppNavigation.Signup)

            NavigateToForgotPassword -> navigateTo(AppNavigation.ForgotPassword)

            NavigateBack -> navigateBack()

            is UpdateField -> updateField(event)
        }
    }

    private fun navigateTo(destination: AppNavigation) {
        emitEffect(BaseEffect.NavigateTo(destination.route))
    }

    private fun navigateBack() {
        emitEffect(BaseEffect.NavigateBack)
    }

    private fun updateField(event: UpdateField) {
        val value = event.value
        when (event.type) {
            UpdateField.FieldType.PASSWORD -> updatePassword(value)
            UpdateField.FieldType.EMAIL -> updateEmail(value)
        }
    }

    private fun updateEmail(email: String) {
        _loginStateFlow.update { loginState ->
            loginState.copy(email = email)
        }
    }

    private fun updatePassword(password: String) {
        _loginStateFlow.update { loginState ->
            loginState.copy(password = password)
        }
    }

    private fun doLogin() {
        navigateTo(AppNavigation.Main)
    }
}
