package com.example.awesomelanguagelearning.login_signup.ui.validator

import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.utils.resource_provider.AppResourceProvider
import com.example.awesomelanguagelearning.core.ui.models.ValidationResult

class NameValidator(
    private val resourceProvider: AppResourceProvider
) {
    fun validate(name: String): ValidationResult =
        when {
            name.isBlank() -> ValidationResult(
                isValid = false,
                errorMessage = resourceProvider.getString(R.string.field_cant_be_blank)
            )
            containsNotOnlyLetters(name) -> ValidationResult(
                isValid = false,
                errorMessage = resourceProvider.getString(R.string.field_can_contain_only_letters)
            )
            else -> ValidationResult(isValid = true)
        }

    private fun containsNotOnlyLetters(name: String): Boolean =
        name.any { !it.isLetter() }
}
