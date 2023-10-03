package com.example.awesomelanguagelearning.login_signup.ui.sign_up

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CreateAccountViewModel : ViewModel() {
    private val _createAccountStateFlow = MutableStateFlow(CreateAccountState())
    val createAccountStateFlow = _createAccountStateFlow.asStateFlow()

    private val _createAccountResultFlow = Channel<Unit>()
    val createAccountResultFlow = _createAccountResultFlow.receiveAsFlow()

    fun updateEmail(email: String) {
        _createAccountStateFlow.update { signupState ->
            signupState.copy(email = email)
        }
    }

    fun updateFirstName(firstName: String) {
        _createAccountStateFlow.update { signupState ->
            signupState.copy(firstName = firstName)
        }
    }

    fun updateLastName(lastName: String) {
        _createAccountStateFlow.update { signupState ->
            signupState.copy(lastName = lastName)
        }
    }

    fun continueSignup() {
        viewModelScope.launch {
            _createAccountResultFlow.send(Unit)
        }
    }
}
