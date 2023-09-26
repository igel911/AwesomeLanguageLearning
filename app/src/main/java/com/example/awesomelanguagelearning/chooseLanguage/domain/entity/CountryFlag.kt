package com.example.awesomelanguagelearning.chooseLanguage.domain.entity

import androidx.annotation.DrawableRes
import com.example.awesomelanguagelearning.R

enum class CountryFlag(
    @DrawableRes
    val flagId: Int,
    val language: String
) {

    CHINA(R.drawable.ic_flag_china, "Chinese"),
    FINLAND(R.drawable.ic_flag_finland, "Finnish"),
    FRANCE(R.drawable.ic_flag_france, "French"),
    GERMANY(R.drawable.ic_flag_germany, "German"),
    INDIA(R.drawable.ic_flag_india, "Hindi"),
    ISRAEL(R.drawable.ic_flag_israel, "Hebrew"),
    ITALY(R.drawable.ic_flag_italy, "Italian"),
    JAPAN(R.drawable.ic_flag_japan, "Japanese"),
    POLAND(R.drawable.ic_flag_poland, "Polish"),
    ROMANIA(R.drawable.ic_flag_romania, "Romanian"),
    SPAIN(R.drawable.ic_flag_spain, "Spanish"),
    SWEDEN(R.drawable.ic_flag_sweden, "Sweden"),
    UKRAINE(R.drawable.ic_flag_ukraine, "Ukrainian"),
    UNITED_KINGDOM(R.drawable.ic_flag_united_kingdom, "English");

    companion object {

        fun byCountryLanguage(language: String): CountryFlag? =
            values().firstOrNull { flag ->
                flag.language.contentEquals(language, ignoreCase = true)
            }
    }
}
