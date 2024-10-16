package com.cami.composeapp.core.providers

import android.content.Context
import androidx.annotation.ArrayRes
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class StringProviderImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : StringProvider {

    override fun getString(@StringRes resId: Int): String = context.getString(resId)

    @Suppress("SpreadOperator")
    override fun getString(
        @StringRes resId: Int,
        vararg formatArgs: Any
    ): String = context.getString(resId, *formatArgs)

    override fun getQuantityString(@PluralsRes res: Int, quantity: Int): String =
        context.resources.getQuantityString(res, quantity)

    @Suppress("SpreadOperator")
    override fun getQuantityString(
        @PluralsRes res: Int,
        quantity: Int,
        vararg formatArgs: Any
    ): String = context.resources.getQuantityString(res, quantity, *formatArgs)

    override fun getStringArray(@ArrayRes resId: Int): Array<String> =
        context.resources.getStringArray(resId)
}
