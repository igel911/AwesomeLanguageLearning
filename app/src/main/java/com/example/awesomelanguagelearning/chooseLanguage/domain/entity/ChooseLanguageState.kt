package com.example.awesomelanguagelearning.chooseLanguage.domain.entity

data class ChooseLanguageState(
    val currentPage: Int = 0,
    val pages: List<ChooseLanguagePageState> = emptyList(),
    val isToolbarTitleVisible: Boolean = true
) {
    fun getCurrentPageForTitle(): Int = currentPage + 1

    fun getPageQuantityForTitle(): Int = pages.size - 1
}
