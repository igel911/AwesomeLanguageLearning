package com.example.awesomelanguagelearning.chooseLanguage.domain.entity

data class ChooseLanguagePageState(
    val title: String,
    val subTitle: String = "",
    val items: List<ChooseLanguageListItem> = emptyList(),
    val isLast: Boolean = false
)
