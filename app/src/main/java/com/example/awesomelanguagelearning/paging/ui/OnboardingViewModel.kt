package com.example.awesomelanguagelearning.paging.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OnboardingViewModel: ViewModel() {
    private val _currentPageState =  MutableStateFlow(0)
    val currentPageState = _currentPageState.asStateFlow()

    fun updateCurrentPage(currentPageIndex: Int) {
        viewModelScope.launch {
            _currentPageState.value = currentPageIndex
        }
    }
}