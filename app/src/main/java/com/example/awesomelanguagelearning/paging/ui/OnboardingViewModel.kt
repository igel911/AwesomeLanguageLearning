package com.example.awesomelanguagelearning.paging.ui

import com.example.awesomelanguagelearning.core.ui.models.BaseEffect
import com.example.awesomelanguagelearning.core.ui.navigation.AppNavigation
import com.example.awesomelanguagelearning.core.ui.viewmodels.NavigationViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class OnboardingViewModel : NavigationViewModel() {
    private val _currentPageStateFlow = MutableStateFlow(0)
    val currentPageStateFlow = _currentPageStateFlow.asStateFlow()

    fun onEvent(event: OnboardingEvent) {
        when (event) {
            is OnboardingEvent.ChangePage -> updateCurrentPage(event.pageIndex)

            is OnboardingEvent.NavigateToLogin -> navigateTo(AppNavigation.Login.route)

            is OnboardingEvent.NavigateToChooseLanguage -> navigateTo(AppNavigation.ChooseLanguage.route)
        }
    }

    private fun updateCurrentPage(currentPageIndex: Int) {
        _currentPageStateFlow.value = currentPageIndex
    }

    private fun navigateTo(route: String) {
        emitEffect(BaseEffect.NavigateTo(route))
    }
}