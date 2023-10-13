package com.example.awesomelanguagelearning.paging.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class OnboardingViewModel : ViewModel() {
    private val _currentPageStateFlow = MutableStateFlow(0)
    val currentPageStateFlow = _currentPageStateFlow.asStateFlow()

    fun updateCurrentPage(currentPageIndex: Int) {
        _currentPageStateFlow.value = currentPageIndex
    }
}