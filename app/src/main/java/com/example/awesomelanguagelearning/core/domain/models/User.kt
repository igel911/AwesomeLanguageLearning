package com.example.awesomelanguagelearning.core.domain.models

data class User(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isActive: Boolean = false
) {
    val arePasswordsCorrect: Boolean =
        password.isNotBlank() && confirmPassword.isNotBlank()

    val isUserDataCorrect: Boolean = email.isNotBlank()
            && firstName.isNotBlank()
            && lastName.isNotBlank()

    val arePasswordsNotEqual: Boolean =
        password != confirmPassword
}
