package com.hasankcay.base.base_network

import android.content.Context
import com.hasankcay.base.base_utils.HttpClient
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitBuilder @Inject constructor(@ApplicationContext private val context: Context) {

    private var interceptors = mutableListOf<Interceptor>()
    private var connectionTimeout = HttpClient.CONNECT_TIMEOUT
    private var writeTimeout = HttpClient.WRITE_TIMEOUT
    private var readTimeout = HttpClient.READ_TIMEOUT
    private var baseUrl: String = "https://api.github.com/"

    fun addInterceptors(vararg interceptor: Interceptor): RetrofitBuilder {
        interceptors.addAll(interceptor)
        return this
    }

    /**
     * This func makes a Retrofit
     */
    fun build(): Retrofit {
        val clientBuilder = OkHttpClient.Builder().apply {
            connectTimeout(connectionTimeout, TimeUnit.SECONDS)
            readTimeout(readTimeout, TimeUnit.SECONDS)
            writeTimeout(writeTimeout, TimeUnit.SECONDS)

            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })

            interceptors.forEach { addInterceptor(it) }
        }

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(clientBuilder.build())

            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    }
}