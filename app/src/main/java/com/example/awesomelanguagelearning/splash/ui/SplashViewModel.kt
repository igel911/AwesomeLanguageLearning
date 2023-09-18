package com.example.awesomelanguagelearning.splash.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    private val _goToNextScreenFlow = MutableSharedFlow<Boolean>()
    val goToNextScreenFlow = _goToNextScreenFlow.asSharedFlow()
    fun startTimer() {
        viewModelScope.launch {
            delay(2000L)
            _goToNextScreenFlow.emit(true)
        }
    }
}