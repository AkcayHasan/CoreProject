package com.hasankcay.coreproject.di

import com.hasankcay.coreproject.util.ApiKeyInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesApiKeyInterceptor(): Interceptor = ApiKeyInterceptor()

}