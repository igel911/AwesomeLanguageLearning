package com.example.awesomelanguagelearning.chooseLanguage.domain.usecase

import com.example.awesomelanguagelearning.R
import com.example.awesomelanguagelearning.chooseLanguage.domain.entity.ChooseLanguageListItem
import com.example.awesomelanguagelearning.chooseLanguage.domain.entity.ChooseLanguagePageState
import com.example.awesomelanguagelearning.chooseLanguage.domain.entity.CountryFlag
import com.example.awesomelanguagelearning.core.ui.utils.coroutines.DispatcherProvider
import com.example.awesomelanguagelearning.core.ui.utils.resource_provider.ResourceProvider
import kotlinx.coroutines.withContext

class GetChooseLanguageContentUseCase(
    private val dispatcherProvider: DispatcherProvider,
    private val resourceProvider: ResourceProvider
) {

    suspend operator fun invoke(): List<ChooseLanguagePageState> {
        return withContext(dispatcherProvider.io) {
            listOf(
                getFirstPageState(),
                getSecondPageState(),
                getThirdPageState(),
                getFourthPageState(),
                getFifthPageState(),
                getSixthPageState(),
                getSeventhPageState()
            )
        }
    }

    private fun getFirstPageState(): ChooseLanguagePageState =
        ChooseLanguagePageState(
            title = resourceProvider.getString(R.string.what_your_language),
            items = CountryFlag.values().map { countryFlag ->
                ChooseLanguageListItem(
                    title = countryFlag.language,
                    icon = countryFlag.flagId
                )
            }
        )

    private fun getSecondPageState(): ChooseLanguagePageState =
        ChooseLanguagePageState(
            title = resourceProvider.getString(R.string.what_main_reason_learn),
            items = resourceProvider.getArray(R.array.reason_learn_variants).map { item ->
                ChooseLanguageListItem(title = item)
            }
        )

    private fun getThirdPageState(): ChooseLanguagePageState =
        ChooseLanguagePageState(
            title = resourceProvider.getString(R.string.how_much_know),
            items = resourceProvider.getArray(R.array.reason_know_variants).map { item ->
                ChooseLanguageListItem(title = item)
            }
        )

    private fun getFourthPageState(): ChooseLanguagePageState =
        ChooseLanguagePageState(
            title = resourceProvider.getString(R.string.how_old_you),
            items = resourceProvider.getArray(R.array.how_old_variants).map { item ->
                ChooseLanguageListItem(title = item)
            }
        )

    private fun getFifthPageState(): ChooseLanguagePageState =
        ChooseLanguagePageState(
            title = resourceProvider.getString(R.string.how_much_learn),
            items = resourceProvider.getArray(R.array.how_much_learn_variants).map { item ->
                ChooseLanguageListItem(title = item)
            }
        )

    private fun getSixthPageState(): ChooseLanguagePageState =
        ChooseLanguagePageState(
            title = resourceProvider.getString(R.string.how_you_hear),
            items = resourceProvider.getArray(R.array.how_hear_variants).map { item ->
                ChooseLanguageListItem(title = item)
            }
        )

    private fun getSeventhPageState(): ChooseLanguagePageState =
        ChooseLanguagePageState(
            title = resourceProvider.getString(R.string.course_overview),
            subTitle = resourceProvider.getString(R.string.overview_text),
            isLast = true
        )
}