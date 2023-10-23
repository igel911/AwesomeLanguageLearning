package com.example.awesomelanguagelearning.chooseLanguage.ui

import androidx.lifecycle.viewModelScope
import com.example.awesomelanguagelearning.chooseLanguage.domain.entity.ChooseLanguageState
import com.example.awesomelanguagelearning.chooseLanguage.domain.usecase.GetChooseLanguageContentUseCase
import com.example.awesomelanguagelearning.core.ui.models.BaseEffect
import com.example.awesomelanguagelearning.core.ui.navigation.AppNavigation
import com.example.awesomelanguagelearning.core.ui.viewmodels.NavigationViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

class ChooseLanguageViewModel(
    val getChooseLanguageContentUseCase: GetChooseLanguageContentUseCase
) : NavigationViewModel() {

    private val _state = MutableStateFlow(ChooseLanguageState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(
                    pages = getChooseLanguageContentUseCase()
                )
            }
        }
    }

    fun onEvent(event: ChooseLanguageEvent) {
        when (event) {
            ChooseLanguageEvent.NavigateNext -> onNext()

            ChooseLanguageEvent.NavigateBack -> chooseBackAction()

            ChooseLanguageEvent.FinishFlow -> navigateTo(AppNavigation.Login)

            is ChooseLanguageEvent.ListItemClick -> onListItemClick(event.id)
        }
    }

    private fun onNext() {
        _state.update { state ->
            val newCurrentPageIndex = state.currentPage + 1
            state.copy(
                currentPage = newCurrentPageIndex,
                isToolbarTitleVisible = newCurrentPageIndex != state.pages.lastIndex
            )
        }
    }

    private fun onBack() {
        _state.update { state ->
            state.copy(
                currentPage = state.currentPage - 1,
                isToolbarTitleVisible = true
            )
        }
    }

    private fun onListItemClick(selectedItemId: UUID) {
        _state.update { state ->
            val updatedItems = state.pages[state.currentPage].items.map { item ->
                item.copy(isSelected = selectedItemId == item.id)
            }

            val updatedPages = state.pages.mapIndexed { index, pageState ->
                if (index == state.currentPage) {
                    pageState.copy(items = updatedItems)
                } else {
                    pageState
                }
            }

            state.copy(pages = updatedPages)
        }
    }

    private fun chooseBackAction() {
        if (_state.value.currentPage > 0) {
            onBack()
        } else {
            navigateBack()
        }
    }

    private fun navigateTo(destination: AppNavigation) {
        emitEffect(BaseEffect.NavigateTo(destination.route))
    }

    private fun navigateBack() {
        emitEffect(BaseEffect.NavigateBack)
    }
}