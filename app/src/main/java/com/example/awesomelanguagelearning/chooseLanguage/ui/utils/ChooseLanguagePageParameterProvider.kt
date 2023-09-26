package com.example.awesomelanguagelearning.chooseLanguage.ui.utils

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.awesomelanguagelearning.chooseLanguage.domain.entity.ChooseLanguageListItem
import com.example.awesomelanguagelearning.chooseLanguage.domain.entity.ChooseLanguagePageState
import com.example.awesomelanguagelearning.chooseLanguage.domain.entity.CountryFlag

class ChooseLanguagePageParameterProvider : PreviewParameterProvider<ChooseLanguagePageState> {
    override val values = sequenceOf(
        ChooseLanguagePageState(
            title = "What Is Your Mother Language?",
            items = CountryFlag.values().map { countryFlag ->
                ChooseLanguageListItem(
                    title = countryFlag.language,
                    icon = countryFlag.flagId
                )
            }
        ),

    )
}