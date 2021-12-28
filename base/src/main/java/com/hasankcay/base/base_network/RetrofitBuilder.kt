package com.hasankcay.base.base_network

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitBuilder @Inject constructor(@ApplicationContext private val context: Context) {

    private var interceptors = mutableListOf<Interceptor>()

    fun addInterceptors(vararg interceptor: Interceptor): RetrofitBuilder {
        interceptors.addAll(interceptor)
        return this
    }

    /**
     * This func makes a Retrofit
     */
    fun build() {

    }
}