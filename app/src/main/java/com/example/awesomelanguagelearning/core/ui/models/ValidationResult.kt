package com.example.awesomelanguagelearning.core.ui.models

data class ValidationResult(
    val isValid: Boolean = false,
    val errorMessage: String? = null
) {

    companion object {
        fun valid() = ValidationResult(isValid = true)
    }
}
