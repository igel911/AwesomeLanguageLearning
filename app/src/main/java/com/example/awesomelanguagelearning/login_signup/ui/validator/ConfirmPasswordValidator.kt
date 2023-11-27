package com.example.awesomelanguagelearning.login_signup.ui.validator

import com.example.awesomelanguagelearning.core.domain.models.User

class ConfirmPasswordValidator(
    private val passwordValidator: PasswordValidator,
    private val repeatedPasswordValidator: RepeatedPasswordValidator
) {
    fun validate(user: User): ConfirmPasswordValidationResult {
        val passwordResult = passwordValidator.validate(user.password)
        val repeatedPasswordResult = repeatedPasswordValidator.validate(
            user.password,
            user.confirmPassword
        )
        return ConfirmPasswordValidationResult(
            passwordValidationResult = passwordResult,
            repeatedPasswordValidationResult = repeatedPasswordResult
        )
    }
}