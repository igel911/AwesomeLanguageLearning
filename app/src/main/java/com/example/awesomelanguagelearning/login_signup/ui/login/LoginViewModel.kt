package com.example.awesomelanguagelearning.login_signup.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _loginStateFlow = MutableStateFlow(LoginState())
    val loginStateFlow = _loginStateFlow.asStateFlow()

    private val _loginResultFlow = Channel<Unit>()
    val loginResultFlow = _loginResultFlow.receiveAsFlow()

    fun updateEmail(email: String) {
        _loginStateFlow.update { loginState ->
            loginState.copy(email = email)
        }
    }

    fun updatePassword(password: String) {
        _loginStateFlow.update { loginState ->
            loginState.copy(password = password)
        }
    }

    fun doLogin() {
        viewModelScope.launch {
            _loginResultFlow.send(Unit)
        }
    }
}
