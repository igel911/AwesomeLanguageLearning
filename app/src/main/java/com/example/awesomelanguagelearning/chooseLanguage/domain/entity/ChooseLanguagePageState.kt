package com.example.awesomelanguagelearning.chooseLanguage.domain.entity

data class ChooseLanguagePageState(
    val title: String,
    val subTitle: String = "",
    val items: List<ChooseLanguageListItem> = emptyList(),
    val isOverview: Boolean = false,
    val isLast: Boolean = false
)
