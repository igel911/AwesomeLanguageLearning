package com.example.awesomelanguagelearning.login_signup.ui.validator

import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.utils.resource_provider.AppResourceProvider
import com.example.awesomelanguagelearning.core.ui.models.ValidationResult

data class RepeatedPasswordValidator(
    private val resourceProvider: AppResourceProvider
) {
    fun validate(
        password: String,
        repeatedPassword: String
    ): ValidationResult =
        if (password != repeatedPassword) {
            ValidationResult(
                isValid = false,
                errorMessage = resourceProvider.getString(R.string.passwords_dont_match)
            )
        } else {
            ValidationResult(isValid = true)
        }
}
