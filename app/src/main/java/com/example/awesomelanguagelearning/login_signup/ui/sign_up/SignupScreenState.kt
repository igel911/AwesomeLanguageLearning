package com.example.awesomelanguagelearning.login_signup.ui.sign_up

import com.example.awesomelanguagelearning.core.domain.models.User
import com.example.awesomelanguagelearning.login_signup.ui.validator.ConfirmPasswordValidationResult
import com.example.awesomelanguagelearning.login_signup.ui.validator.CreateAccountValidationResult

data class SignupScreenState(
    val currentPage: Int = 0,
    val pageQuantity: Int = 2,
    val user: User = User(),
    val createAccountValidationResult: CreateAccountValidationResult = CreateAccountValidationResult.valid(),
    val confirmPasswordValidationResult: ConfirmPasswordValidationResult = ConfirmPasswordValidationResult.valid()
)
