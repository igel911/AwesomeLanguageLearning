package com.example.awesomelanguagelearning.paging.ui

sealed interface OnboardingEvent {

    data class ChangePage(val pageIndex: Int) : OnboardingEvent

    object NavigateToLogin : OnboardingEvent

    object NavigateToChooseLanguage : OnboardingEvent
}
