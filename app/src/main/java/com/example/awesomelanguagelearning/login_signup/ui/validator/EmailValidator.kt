package com.example.awesomelanguagelearning.login_signup.ui.validator

import android.util.Patterns
import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.core.ui.utils.resource_provider.AppResourceProvider
import com.example.awesomelanguagelearning.core.ui.models.ValidationResult

class EmailValidator(
    private val resourceProvider: AppResourceProvider
) {
    fun validate(email: String): ValidationResult =
        when {
            email.isBlank() -> ValidationResult(
                isValid = false,
                errorMessage = resourceProvider.getString(R.string.email_cant_be_blank)
            )
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> ValidationResult(
                isValid = false,
                errorMessage = resourceProvider.getString(R.string.not_valid_email)
            )
            else -> ValidationResult(isValid = true)
        }
}