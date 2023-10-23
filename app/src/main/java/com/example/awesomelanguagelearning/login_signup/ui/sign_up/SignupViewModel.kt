package com.example.awesomelanguagelearning.login_signup.ui.sign_up

import androidx.lifecycle.viewModelScope
import com.example.awesomelanguagelearning.core.ui.models.BaseEffect
import com.example.awesomelanguagelearning.core.ui.navigation.AppNavigation
import com.example.awesomelanguagelearning.core.ui.viewmodels.NavigationViewModel
import com.example.awesomelanguagelearning.login_signup.domain.entity.SignupResult
import com.example.awesomelanguagelearning.login_signup.domain.usecase.DoSignupUseCase
import com.example.awesomelanguagelearning.login_signup.ui.sign_up.SignupEvent.UpdateField.FieldType.CONFIRM_PASSWORD
import com.example.awesomelanguagelearning.login_signup.ui.sign_up.SignupEvent.UpdateField.FieldType.EMAIL
import com.example.awesomelanguagelearning.login_signup.ui.sign_up.SignupEvent.UpdateField.FieldType.FIRST_NAME
import com.example.awesomelanguagelearning.login_signup.ui.sign_up.SignupEvent.UpdateField.FieldType.LAST_NAME
import com.example.awesomelanguagelearning.login_signup.ui.sign_up.SignupEvent.UpdateField.FieldType.PASSWORD
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignupViewModel(
    private val doSignupUseCase: DoSignupUseCase
) : NavigationViewModel() {

    private val _state = MutableStateFlow(SignupScreenState())
    val state = _state.asStateFlow()

    private val _signupResultFlow = Channel<SignupResult>()
    val signupResultFlow = _signupResultFlow.receiveAsFlow()


    fun onEvent(event: SignupEvent) {
        when (event) {
            SignupEvent.DoSignup -> doSignup()

            SignupEvent.ContinueSignupDataSetup -> onNext()

            SignupEvent.LoginByFacebook -> {}

            SignupEvent.LoginByGoogle -> {}

            SignupEvent.NavigateToLogin -> navigateTo(AppNavigation.Login)

            SignupEvent.NavigateBack -> chooseBackAction()

            is SignupEvent.UpdateField -> updateField(event)

        }
    }

    private fun updateField(event: SignupEvent.UpdateField) {
        val value = event.value
        when (event.type) {
            PASSWORD -> updatePassword(value)
            CONFIRM_PASSWORD -> updateConfirmPassword(value)
            EMAIL -> updateEmail(value)
            FIRST_NAME -> updateFirstName(value)
            LAST_NAME -> updateLastName(value)
        }
    }

    private fun updateEmail(email: String) {
        _state.update { signupScreenState ->
            signupScreenState.copy(user = signupScreenState.user.copy(email = email))
        }
    }

    private fun updateFirstName(firstName: String) {
        _state.update { signupScreenState ->
            signupScreenState.copy(user = signupScreenState.user.copy(firstName = firstName))
        }
    }

    private fun updateLastName(lastName: String) {
        _state.update { signupScreenState ->
            signupScreenState.copy(user = signupScreenState.user.copy(lastName = lastName))
        }
    }

    private fun updateConfirmPassword(confirmPassword: String) {
        _state.update { signupScreenState ->
            signupScreenState.copy(user = signupScreenState.user.copy(confirmPassword = confirmPassword))
        }
    }

    private fun updatePassword(password: String) {
        _state.update { signupScreenState ->
            signupScreenState.copy(user = signupScreenState.user.copy(password = password))
        }
    }

    private fun doSignup() {
        viewModelScope.launch {
            val signupResult = doSignupUseCase(_state.value.user)
            if (signupResult.isSuccessful) {
                navigateTo(AppNavigation.Main)
            } else {
                _signupResultFlow.send(signupResult)
            }
        }
    }

    private fun onNext() {
        _state.update { state ->
            state.copy(currentPage = state.currentPage + 1)
        }
    }

    private fun onBack() {
        _state.update { state ->
            state.copy(currentPage = state.currentPage - 1)
        }
    }

    private fun chooseBackAction() {
        if (_state.value.currentPage > 0) {
            onBack()
        } else {
            navigateBack()
        }
    }

    private fun navigateTo(destination: AppNavigation) {
        emitEffect(BaseEffect.NavigateTo(destination.route))
    }

    private fun navigateBack() {
        emitEffect(BaseEffect.NavigateBack)
    }
}