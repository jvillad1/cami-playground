package com.cami.composeapp.core.data.extensions

import okhttp3.Request

// Bearer Authentication
private const val HTTP_AUTHORIZATION_HEADER = "Authorization"
private const val BEARER_TOKEN_PREFIX = "Bearer "
private const val BEARER_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3MWQzOWE1N2U2OGY5Y2Q3ODViNTEyNmQ1OTk1MzQ4ZCIsIm5iZiI6MTcyODQ1ODI2NC4xMzIyNjMsInN1YiI6IjU5Yzc2NTJkOTI1MTQxNWI1NDA1MzczZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.wOXBCQvyvYo7IzeouGntdXannNBiUKJxAQ9uXqR-DAg"

/**
 * Returns the Bearer Authentication Header for the given token of type [String]
 */
private fun getBearerAuthHeader(): String = BEARER_TOKEN_PREFIX.plus(BEARER_TOKEN)

/**
 * Signs the [Request] with the given token as Header
 *
 * @return [Request] with Authorization token as Header
 */
fun Request.signWithToken() = newBuilder()
    .header(HTTP_AUTHORIZATION_HEADER, getBearerAuthHeader())
    .build()
