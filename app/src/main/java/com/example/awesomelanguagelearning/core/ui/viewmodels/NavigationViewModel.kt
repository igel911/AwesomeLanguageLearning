package com.example.awesomelanguagelearning.core.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.awesomelanguagelearning.core.ui.navigation.BaseEffect
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

abstract class NavigationViewModel : ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler(::onError)

    private val _effect = Channel<BaseEffect>(Channel.BUFFERED)
    val effect: Flow<BaseEffect> = _effect.receiveAsFlow()

    open fun onError(context: CoroutineContext, throwable: Throwable) = Unit

    protected fun emitEffect(effect: BaseEffect) {
        launchOnMain {
            _effect.send(effect)
        }
    }

    private fun launchOnMain(block: suspend CoroutineScope.() -> Unit): Job {
        return viewModelScope.launch(exceptionHandler, block = block)
    }
}