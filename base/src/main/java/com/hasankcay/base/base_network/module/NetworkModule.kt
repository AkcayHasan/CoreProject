package com.hasankcay.base.base_network.module

import com.hasankcay.base.base_network.HeaderInterceptor
import com.hasankcay.base.base_network.RetrofitBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(
        retrofitBuilder: RetrofitBuilder,
        headerInterceptor: HeaderInterceptor
    ): Retrofit {
        return retrofitBuilder.addInterceptors(headerInterceptor).build()
    }

}