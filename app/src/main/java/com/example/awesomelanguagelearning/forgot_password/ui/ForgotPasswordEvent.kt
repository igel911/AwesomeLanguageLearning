package com.example.awesomelanguagelearning.forgot_password.ui

sealed interface ForgotPasswordEvent {

    object NavigateBack : ForgotPasswordEvent

    object DoPasswordRestore : ForgotPasswordEvent

    data class UpdateEmail(val value: String) : ForgotPasswordEvent
}