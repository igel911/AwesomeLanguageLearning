package com.example.awesomelanguagelearning.core.ui.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import com.example.awesomelanguagelearning.core.ui.models.BaseEffect
import com.example.awesomelanguagelearning.core.ui.viewmodels.NavigationViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun BaseComposableScreen(
    navController: NavController,
    viewModel: NavigationViewModel,
    onEffect: (suspend (BaseEffect) -> Unit)? = null,
    content: @Composable (coroutineScope: CoroutineScope) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is BaseEffect.NavigateTo -> {
                    coroutineScope.launch {
                        navController.navigate(effect.route)
                    }
                }
                is BaseEffect.NavigateBackTo -> {
                    coroutineScope.launch {
                        navController.popBackStack(
                            effect.destination,
                            effect.inclusive,
                        )
                    }
                }
                is BaseEffect.NavigateBack -> {
                    coroutineScope.launch {
                        navController.popBackStack()
                    }
                }
                else -> onEffect?.invoke(effect)
            }
        }
    }

    content(coroutineScope)
}