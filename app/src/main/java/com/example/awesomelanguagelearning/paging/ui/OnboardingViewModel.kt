package com.example.awesomelanguagelearning.paging.ui

import com.example.awesomelanguagelearning.core.ui.models.BaseEffect
import com.example.awesomelanguagelearning.core.ui.navigation.AppNavigation
import com.example.awesomelanguagelearning.core.ui.viewmodels.NavigationViewModel
import com.example.awesomelanguagelearning.paging.ui.OnboardingEvent.ChangePage
import com.example.awesomelanguagelearning.paging.ui.OnboardingEvent.NavigateToChooseLanguage
import com.example.awesomelanguagelearning.paging.ui.OnboardingEvent.NavigateToLogin
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class OnboardingViewModel : NavigationViewModel() {
    private val _currentPageStateFlow = MutableStateFlow(0)
    val currentPageStateFlow = _currentPageStateFlow.asStateFlow()

    fun onEvent(event: OnboardingEvent) {
        when (event) {
            NavigateToLogin -> navigateTo(AppNavigation.Login)

            NavigateToChooseLanguage -> navigateTo(AppNavigation.ChooseLanguage)

            is ChangePage -> updateCurrentPage(event.pageIndex)
        }
    }

    private fun updateCurrentPage(currentPageIndex: Int) {
        _currentPageStateFlow.value = currentPageIndex
    }

    private fun navigateTo(destination: AppNavigation) {
        emitEffect(BaseEffect.NavigateTo(destination.route))
    }
}