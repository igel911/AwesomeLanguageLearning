package com.example.awesomelanguagelearning.chooseLanguage.domain.entity

import java.util.UUID

data class ChooseLanguageListItem(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val icon: Int? = null,
    val isSelected: Boolean = false
)
