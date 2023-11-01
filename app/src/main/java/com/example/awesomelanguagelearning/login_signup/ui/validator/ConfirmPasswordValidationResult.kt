package com.example.awesomelanguagelearning.login_signup.ui.validator

import com.example.awesomelanguagelearning.core.ui.models.ValidationResult

data class ConfirmPasswordValidationResult(
    val passwordValidationResult: ValidationResult,
    val repeatedPasswordValidationResult: ValidationResult
) {
    fun isValid(): Boolean =
        listOf(
            passwordValidationResult,
            repeatedPasswordValidationResult
        ).all { it.isValid }

    companion object {

        fun valid() = ConfirmPasswordValidationResult(
            passwordValidationResult = ValidationResult.valid(),
            repeatedPasswordValidationResult = ValidationResult.valid()
        )
    }
}