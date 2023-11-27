package com.example.awesomelanguagelearning.login_signup.ui.validator

import com.example.awesomelanguagelearning.core.ui.models.ValidationResult

data class CreateAccountValidationResult(
    val emailValidationResult: ValidationResult,
    val firstNameValidationResult: ValidationResult,
    val lastNameValidationResult: ValidationResult
) {
    fun isValid(): Boolean =
        listOf(
            emailValidationResult,
            firstNameValidationResult,
            lastNameValidationResult
        ).all { it.isValid }

    companion object {

        fun valid() = CreateAccountValidationResult(
            emailValidationResult = ValidationResult.valid(),
            firstNameValidationResult = ValidationResult.valid(),
            lastNameValidationResult = ValidationResult.valid()
        )
    }
}