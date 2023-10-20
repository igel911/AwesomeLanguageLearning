package com.example.awesomelanguagelearning.login_signup.ui.login

import com.example.awesomelanguagelearning.core.ui.models.BaseEffect
import com.example.awesomelanguagelearning.core.ui.navigation.AppNavigation
import com.example.awesomelanguagelearning.core.ui.viewmodels.NavigationViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : NavigationViewModel() {
    private val _loginStateFlow = MutableStateFlow(LoginState())
    val loginStateFlow = _loginStateFlow.asStateFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.DoLogin -> doLogin()

            is LoginEvent.LoginByFacebook -> {}

            is LoginEvent.LoginByGoogle -> {}

            is LoginEvent.NavigateToSignup -> navigateTo(AppNavigation.Signup)

            is LoginEvent.NavigateToForgotPassword -> navigateTo(AppNavigation.ForgotPassword)

            is LoginEvent.NavigateBack -> navigateBack()

            is LoginEvent.UpdateField -> updateField(event)
        }
    }

    private fun navigateTo(destination: AppNavigation) {
        emitEffect(BaseEffect.NavigateTo(destination.route))
    }

    private fun navigateBack() {
        emitEffect(BaseEffect.NavigateBack)
    }

    private fun updateField(event: LoginEvent.UpdateField) {
        val value = event.value
        when (event.type) {
            LoginEvent.UpdateField.FieldType.PASSWORD -> updatePassword(value)
            LoginEvent.UpdateField.FieldType.EMAIL -> updateEmail(value)
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
