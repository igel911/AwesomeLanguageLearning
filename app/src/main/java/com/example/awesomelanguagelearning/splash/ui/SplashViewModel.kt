package com.example.awesomelanguagelearning.splash.ui

import androidx.lifecycle.viewModelScope
import com.example.awesomelanguagelearning.core.ui.navigation.AppNavigation
import com.example.awesomelanguagelearning.core.ui.navigation.BaseEffect
import com.example.awesomelanguagelearning.core.ui.viewmodels.NavigationViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : NavigationViewModel() {

    init {
        startTimer()
    }

    private fun startTimer() {
        viewModelScope.launch {
            delay(2000L)
            emitEffect(BaseEffect.NavigateTo(route = AppNavigation.Onboarding.route))
        }
    }
}