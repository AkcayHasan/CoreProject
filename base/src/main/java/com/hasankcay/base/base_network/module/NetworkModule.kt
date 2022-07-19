package com.hasankcay.base.base_network.module

import android.content.Context
import com.hasankcay.base.base_network.HeaderInterceptor
import com.hasankcay.base.base_network.RetrofitBuilder
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideHeaderInterceptor(
        @ApplicationContext context: Context,
        moshi: Moshi
    ) = HeaderInterceptor(context, moshi)

    @Singleton
    @Provides
    fun provideRetrofit(
        retrofitBuilder: RetrofitBuilder,
        headerInterceptor: HeaderInterceptor //apiKeyInterceptor ın init edilmesi gerekiyor
    ): Retrofit {
        return retrofitBuilder.addInterceptors(headerInterceptor).build()
    }

}