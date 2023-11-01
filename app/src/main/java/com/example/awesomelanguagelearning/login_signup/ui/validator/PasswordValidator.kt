package com.example.awesomelanguagelearning.login_signup.ui.validator

import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.utils.resource_provider.AppResourceProvider
import com.example.awesomelanguagelearning.core.ui.models.ValidationResult

data class PasswordValidator(
    private val resourceProvider: AppResourceProvider
) {
    fun validate(password: String): ValidationResult =
        when {
            password.length < 8 -> ValidationResult(
                isValid = false,
                errorMessage = resourceProvider.getString(R.string.password_too_short)
            )
            !containsNecessarySymbols(password) -> ValidationResult(
                    isValid = false,
                    errorMessage = resourceProvider.getString(R.string.password_without_symbols)
                )
            else -> ValidationResult(isValid = true)
        }

    private fun containsNecessarySymbols(password: String): Boolean =
        password.any { it.isDigit() } && password.any { it.isLetter() }
}