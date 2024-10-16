package com.cami.composeapp.core.data.interceptors

import com.cami.composeapp.core.data.extensions.signWithToken
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import timber.log.Timber
import java.net.ConnectException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AccessTokenInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = try {
        val newRequest = chain.request().signedRequest()

        if (newRequest != null) {
            chain.proceed(newRequest)
        } else {
            chain.proceed(chain.request())
        }
    } catch (connectException: ConnectException) {
        Timber.d("ConnectException ${connectException.message}")
        chain.proceed(chain.request())
    }

    @Suppress("ComplexMethod")
    private fun Request.signedRequest(): Request? = runBlocking {
        signWithToken()
    }
}
