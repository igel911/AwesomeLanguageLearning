package com.example.awesomelanguagelearning.chooseLanguage.domain.entity

data class ChooseLanguageState(
    val currentPage: Int = 0,
    val pages: List<ChooseLanguagePageState> = emptyList()
)
