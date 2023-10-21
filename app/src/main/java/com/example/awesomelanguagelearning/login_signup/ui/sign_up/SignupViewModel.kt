package com.example.awesomelanguagelearning.login_signup.ui.sign_up

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.awesomelanguagelearning.login_signup.domain.entity.SignupResult
import com.example.awesomelanguagelearning.login_signup.domain.usecase.DoSignupUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignupViewModel(
    private val doSignupUseCase: DoSignupUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(SignupScreenState())
    val state = _state.asStateFlow()

    private val _signupResultFlow = Channel<SignupResult>()
    val signupResultFlow = _signupResultFlow.receiveAsFlow()

    fun updateEmail(email: String) {
        _state.update { signupScreenState ->
            signupScreenState.copy(user = signupScreenState.user.copy(email = email))
        }
    }

    fun updateFirstName(firstName: String) {
        _state.update { signupScreenState ->
            signupScreenState.copy(user = signupScreenState.user.copy(firstName = firstName))
        }
    }

    fun updateLastName(lastName: String) {
        _state.update { signupScreenState ->
            signupScreenState.copy(user = signupScreenState.user.copy(lastName = lastName))
        }
    }

    fun updateConfirmPassword(confirmPassword: String) {
        _state.update { signupScreenState ->
            signupScreenState.copy(user = signupScreenState.user.copy(confirmPassword = confirmPassword))
        }
    }

    fun updatePassword(password: String) {
        _state.update { signupScreenState ->
            signupScreenState.copy(user = signupScreenState.user.copy(password = password))
        }
    }

    fun doSignup() {
        viewModelScope.launch {
            val signupResult = doSignupUseCase(_state.value.user)
            _signupResultFlow.send(signupResult)
        }
    }

    fun onNext() {
        _state.update { state ->
            state.copy(currentPage = state.currentPage + 1)
        }
    }

    fun onBack() {
        _state.update { state ->
            state.copy(currentPage = state.currentPage - 1)
        }
    }
}