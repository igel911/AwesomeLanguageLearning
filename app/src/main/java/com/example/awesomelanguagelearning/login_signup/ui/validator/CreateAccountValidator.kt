package com.example.awesomelanguagelearning.login_signup.ui.validator

import com.example.awesomelanguagelearning.core.domain.models.User

class CreateAccountValidator(
    private val emailValidator: EmailValidator,
    private val nameValidator: NameValidator,
    private val lastNameValidator: NameValidator
) {
    fun validate(user: User): CreateAccountValidationResult {
        val emailResult = emailValidator.validate(user.email)
        val firstNameResult = nameValidator.validate(user.firstName)
        val lastNameResult = lastNameValidator.validate(user.lastName)
        return CreateAccountValidationResult(
            emailValidationResult = emailResult,
            firstNameValidationResult = firstNameResult,
            lastNameValidationResult = lastNameResult
        )
    }
}