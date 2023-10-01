package com.example.awesomelanguagelearning.login_signup.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _loginStateFlow = MutableStateFlow(LoginState())
    val loginStateFlow = _loginStateFlow.asStateFlow()

    private val _loginResultFlow = MutableSharedFlow<Boolean>()
    val loginResultFlow = _loginResultFlow.asSharedFlow()

    fun updateEmail(email: String) {
        viewModelScope.launch {
            _loginStateFlow.update { loginState ->
                loginState.copy(email = email)
            }
        }
    }

    fun updatePassword(password: String) {
        viewModelScope.launch {
            _loginStateFlow.update { loginState ->
                loginState.copy(password = password)
            }
        }
    }

    fun doLogin() {
        viewModelScope.launch {
            _loginResultFlow.emit(true)
        }
    }
}
