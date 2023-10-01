package com.example.awesomelanguagelearning.login_signup.ui.sign_up

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ConfirmPasswordViewModel : ViewModel() {
    private val _confirmPasswordStateFlow = MutableStateFlow(ConfirmPasswordState())
    val confirmPasswordStateFlow = _confirmPasswordStateFlow.asStateFlow()

    private val _confirmPasswordFlow = Channel<Unit>()
    val confirmPasswordFlow = _confirmPasswordFlow.receiveAsFlow()

    fun updateConfirmPassword(confirmPassword: String) {
        viewModelScope.launch {
            _confirmPasswordStateFlow.update { confirmPasswordState ->
                confirmPasswordState.copy(confirmPassword = confirmPassword)
            }
        }
    }

    fun updatePassword(password: String) {
        viewModelScope.launch {
            _confirmPasswordStateFlow.update { confirmPasswordState ->
                confirmPasswordState.copy(password = password)
            }
        }
    }

    fun doSignup() {
        viewModelScope.launch {
            _confirmPasswordFlow.send(Unit)
        }
    }
}
