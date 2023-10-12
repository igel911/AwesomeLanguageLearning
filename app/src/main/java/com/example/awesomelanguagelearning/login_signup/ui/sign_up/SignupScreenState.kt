package com.example.awesomelanguagelearning.login_signup.ui.sign_up

import com.example.awesomelanguagelearning.core.domain.models.User

data class SignupScreenState(
    val currentPage: Int = 0,
    val pageQuantity: Int = 2,
    val user: User = User()
)
