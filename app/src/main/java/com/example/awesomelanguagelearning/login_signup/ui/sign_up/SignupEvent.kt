package com.example.awesomelanguagelearning.login_signup.ui.sign_up

sealed interface SignupEvent {

    object NavigateBack : SignupEvent

    object DoSignup : SignupEvent

    object ContinueSignupDataSetup : SignupEvent

    object NavigateToLogin : SignupEvent

    object LoginByFacebook : SignupEvent

    object LoginByGoogle : SignupEvent

    data class UpdateField(
        val value: String,
        val type: FieldType
    ) : SignupEvent {

        enum class FieldType {
            EMAIL, PASSWORD, CONFIRM_PASSWORD, FIRST_NAME, LAST_NAME
        }

        companion object {
            fun updateEmail(value: String): UpdateField =
                UpdateField(value = value, type = FieldType.EMAIL)

            fun updatePassword(value: String) =
                UpdateField(value = value, type = FieldType.PASSWORD)

            fun updateConfirmPassword(value: String) =
                UpdateField(value = value, type = FieldType.CONFIRM_PASSWORD)

            fun updateFirstName(value: String) =
                UpdateField(value = value, type = FieldType.FIRST_NAME)

            fun updateLastName(value: String) =
                UpdateField(value = value, type = FieldType.LAST_NAME)
        }
    }
}