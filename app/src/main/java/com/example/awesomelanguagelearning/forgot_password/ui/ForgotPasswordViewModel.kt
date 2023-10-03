package com.example.awesomelanguagelearning.forgot_password.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.utils.resource_provider.AppResourceProvider
import com.example.awesomelanguagelearning.forgot_password.ui.models.ForgotPasswordState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ForgotPasswordViewModel(
    private val resourceProvider: AppResourceProvider
): ViewModel() {

    private val _emailStateFlow = MutableStateFlow(ForgotPasswordState())
    val emailStateFlow = _emailStateFlow.asStateFlow()

    private val _effect = Channel<String>()
    val effect = _effect.receiveAsFlow()

    fun updateEmail(email: String) {
        viewModelScope.launch {
            _emailStateFlow.update { state ->
                state.copy(
                    email = email,
                    isButtonEnabled = email.isNotBlank()
                )
            }
        }
    }

    fun doForgotPassword() {
        viewModelScope.launch {
            _effect.send(resourceProvider.getString(R.string.forgot_password_error))
        }
    }
}