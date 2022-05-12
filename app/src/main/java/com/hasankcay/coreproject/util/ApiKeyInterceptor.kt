package com.hasankcay.coreproject.util

import com.hasankcay.coreproject.util.Constants.API_KEY
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val httpUrl: HttpUrl = original.url
        val url: HttpUrl = httpUrl.newBuilder()
            .addQueryParameter("api_key", API_KEY)
            .build()
        val request: Request = original.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}