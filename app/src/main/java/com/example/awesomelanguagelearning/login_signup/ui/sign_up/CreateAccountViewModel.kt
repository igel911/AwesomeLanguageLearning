package com.example.awesomelanguagelearning.login_signup.ui.sign_up

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CreateAccountViewModel : ViewModel() {
    private val _createAccountStateFlow = MutableStateFlow(CreateAccountState())
    val createAccountStateFlow = _createAccountStateFlow.asStateFlow()

    fun updateEmail(email: String) {
        viewModelScope.launch {
            _createAccountStateFlow.update { signupState ->
                signupState.copy(email = email)
            }
        }
    }

    fun updateFirstName(firstName: String) {
        viewModelScope.launch {
            _createAccountStateFlow.update { signupState ->
                signupState.copy(firstName = firstName)
            }
        }
    }

    fun updateLastName(lastName: String) {
        viewModelScope.launch {
            _createAccountStateFlow.update { signupState ->
                signupState.copy(lastName = lastName)
            }
        }
    }

    fun continueSignup() {

    }

    fun goToLogin() {

    }

    fun doLoginByFacebook() {

    }

    fun doLoginByGoogle() {

    }
}