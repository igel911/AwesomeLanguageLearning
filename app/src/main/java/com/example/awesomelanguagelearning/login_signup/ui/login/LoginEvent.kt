package com.example.awesomelanguagelearning.login_signup.ui.login

sealed interface LoginEvent {

    object NavigateBack : LoginEvent

    object DoLogin : LoginEvent

    object NavigateToSignup : LoginEvent

    object LoginByFacebook : LoginEvent

    object LoginByGoogle : LoginEvent

    object NavigateToForgotPassword : LoginEvent

    data class UpdateField(
        val value: String,
        val type: FieldType
    ) : LoginEvent {

        enum class FieldType {
            EMAIL, PASSWORD
        }

        companion object {
            fun updateEmail(value: String): UpdateField = UpdateField(value = value, type = FieldType.EMAIL)
            fun updatePassword(value: String) =
                UpdateField(value = value, type = FieldType.PASSWORD)
        }
    }
}