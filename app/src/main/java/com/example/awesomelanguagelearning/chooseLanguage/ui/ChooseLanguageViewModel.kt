package com.example.awesomelanguagelearning.chooseLanguage.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.awesomelanguagelearning.chooseLanguage.domain.entity.ChooseLanguageState
import com.example.awesomelanguagelearning.chooseLanguage.domain.usecase.GetChooseLanguageContentUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

class ChooseLanguageViewModel(
    val getChooseLanguageContentUseCase: GetChooseLanguageContentUseCase
) : ViewModel() {

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

    fun onNext() {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(currentPage = state.currentPage + 1)
            }
        }
    }

    fun onBack() {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(currentPage = state.currentPage - 1)
            }
        }
    }

    fun onListItemClick(selectedItemId: UUID) {
        viewModelScope.launch {
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
    }
}