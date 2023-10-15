package com.example.awesomelanguagelearning.core.domain.models

data class User(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isActive: Boolean = false
) {
    fun arePasswordsCorrect(): Boolean =
        password.isNotBlank() && confirmPassword.isNotBlank()

    fun isUserDataCorrect(): Boolean = email.isNotBlank()
            && firstName.isNotBlank()
            && lastName.isNotBlank()

    fun arePasswordsNotEqual(): Boolean =
        password != confirmPassword
}
