package com.example.awesomelanguagelearning.core.ui.models

interface BaseEffect {
    data class NavigateTo(val route: String) : BaseEffect

    data class NavigateBackTo(
        val destination: String,
        val inclusive: Boolean = false,
    ) : BaseEffect

    object NavigateBack : BaseEffect
}