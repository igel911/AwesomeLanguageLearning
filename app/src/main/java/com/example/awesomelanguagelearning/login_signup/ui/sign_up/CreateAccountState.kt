package com.example.awesomelanguagelearning.login_signup.ui.sign_up

data class CreateAccountState(
    val email: String = "",
    val firstName: String = "",
    val lastName: String = ""
) {
    val isCredentialsCorrect: Boolean = email.isNotBlank()
            && firstName.isNotBlank()
            && lastName.isNotBlank()
}