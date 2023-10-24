package com.example.awesomelanguagelearning.chooseLanguage.ui

import java.util.UUID

sealed interface ChooseLanguageEvent {

    object NavigateBack : ChooseLanguageEvent

    object NavigateNext : ChooseLanguageEvent

    object FinishFlow : ChooseLanguageEvent

    data class ListItemClick(val id: UUID) : ChooseLanguageEvent
}