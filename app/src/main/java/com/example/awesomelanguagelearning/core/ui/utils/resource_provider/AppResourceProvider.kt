package com.example.awesomelanguagelearning.core.ui.utils.resource_provider

import android.content.Context
import androidx.annotation.ArrayRes
import androidx.annotation.StringRes

class AppResourceProvider(
    private val context: Context
) : ResourceProvider {

    override fun getString(@StringRes stringId: Int): String =
        context.getString(stringId)

    override fun getString(@StringRes stringId: Int, vararg args: Any?): String =
        context.getString(stringId, *args)

    override fun getArray(@ArrayRes arrayId: Int): Array<String> =
        context.resources.getStringArray(arrayId)
}
