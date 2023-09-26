package com.example.awesomelanguagelearning.core.ui.utils.resource_provider

import androidx.annotation.ArrayRes
import androidx.annotation.StringRes

interface ResourceProvider {

    fun getString(@StringRes stringId: Int): String

    fun getString(@StringRes stringId: Int, vararg args: Any?): String

    fun getArray(@ArrayRes arrayId: Int): Array<String>
}
