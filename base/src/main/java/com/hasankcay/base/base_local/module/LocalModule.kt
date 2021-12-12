package com.hasankcay.base.base_local.module

import android.content.Context
import com.google.gson.Gson
import com.hasankcay.base.base_local.DataStorePrefImpl
import com.hasankcay.base.base_local.IDataStorePref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Provides
    @Singleton
    fun provideDataStoreInstance(@ApplicationContext context: Context, gson: Gson): IDataStorePref {
        return DataStorePrefImpl(context, gson)
    }

    @Provides
    @Singleton
    fun provideGsonInstance() = Gson()
}