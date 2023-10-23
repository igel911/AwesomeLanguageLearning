package com.example.awesomelanguagelearning.forgot_password.ui

import androidx.lifecycle.viewModelScope
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.models.BaseEffect
import com.example.awesomelanguagelearning.core.ui.utils.resource_provider.AppResourceProvider
import com.example.awesomelanguagelearning.core.ui.viewmodels.NavigationViewModel
import com.example.awesomelanguagelearning.forgot_password.ui.ForgotPasswordEvent.DoPasswordRestore
import com.example.awesomelanguagelearning.forgot_password.ui.ForgotPasswordEvent.NavigateBack
import com.example.awesomelanguagelearning.forgot_password.ui.ForgotPasswordEvent.UpdateEmail
import com.example.awesomelanguagelearning.forgot_password.ui.models.ForgotPasswordState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ForgotPasswordViewModel(
    private val resourceProvider: AppResourceProvider
) : NavigationViewModel() {

    private val _emailStateFlow = MutableStateFlow(ForgotPasswordState())
    val emailStateFlow = _emailStateFlow.asStateFlow()

    private val _forgotPasswordErrorState = Channel<String>()
    val forgotPasswordErrorState = _forgotPasswordErrorState.receiveAsFlow()

    fun onEvent(event: ForgotPasswordEvent) {
        when(event) {
            DoPasswordRestore -> doForgotPassword()
            NavigateBack -> navigateBack()
            is UpdateEmail -> updateEmail(event.value)
        }
    }

    private fun updateEmail(email: String) {
        _emailStateFlow.update { state ->
            state.copy(
                email = email,
                isButtonEnabled = email.isNotBlank()
            )
        }
    }

    private fun doForgotPassword() {
        viewModelScope.launch {
            _forgotPasswordErrorState.send(resourceProvider.getString(R.string.forgot_password_error))
        }
    }

    private fun navigateBack() {
        emitEffect(BaseEffect.NavigateBack)
    }
}