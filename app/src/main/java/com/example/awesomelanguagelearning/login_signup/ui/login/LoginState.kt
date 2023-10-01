package com.example.awesomelanguagelearning.login_signup.ui.login

data class LoginState(
    val email: String = "",
    val password: String = ""
) {
    val isCredentialsCorrect: Boolean = email.isNotBlank() && password.isNotBlank()
}