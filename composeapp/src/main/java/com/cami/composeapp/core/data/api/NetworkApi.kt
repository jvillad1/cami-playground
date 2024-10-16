package com.cami.composeapp.core.data.api

import com.cami.composeapp.R
import com.cami.composeapp.core.providers.StringProvider
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class NetworkApi @Inject constructor(
    private val stringProvider: StringProvider
) {

    fun parseError(throwable: Throwable): String = when (throwable) {
        is ConnectException, is UnknownHostException ->
            stringProvider.getString(R.string.not_connected_description)

        is SocketTimeoutException -> stringProvider.getString(R.string.service_unavailable_description)

        else -> stringProvider.getString(R.string.something_went_wrong_description)
    }
}
