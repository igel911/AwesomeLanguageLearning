package com.example.awesomelanguagelearning.login_signup.domain.entity

data class SignupResult(
    val isSuccessful: Boolean,
    val errorMessage: String? = null
)
