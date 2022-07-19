package com.hasankcay.base.base_network

import android.content.Context
import com.hasankcay.base.base_local.datastore.DataStorePrefImpl
import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(
    private val context: Context,
    private val moshi: Moshi
) : Interceptor {

    private var authToken: String? = null

    override fun intercept(chain: Interceptor.Chain): Response {
        CoroutineScope(Dispatchers.Main).launch {
            authToken = DataStorePrefImpl(context, moshi).getAuthorizationToken()
        }

        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Content-Type", "application/json")
            .apply {
                authToken?.let { addHeader("Authorization", "Bearer $it") }
            }
            .build()

        return chain.proceed(request)
    }
}