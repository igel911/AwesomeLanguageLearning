package com.example.awesomelanguagelearning.splash.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {
    private val _goToNextScreenFlow = Channel<Unit>()
    val goToNextScreenFlow = _goToNextScreenFlow.receiveAsFlow()

    fun startTimer() {
        viewModelScope.launch {
            delay(2000L)
            _goToNextScreenFlow.send(Unit)
        }
    }
}