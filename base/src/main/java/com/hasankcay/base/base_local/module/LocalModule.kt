package com.hasankcay.base.base_local.module

import android.content.Context
import com.hasankcay.base.base_local.datastore.DataStorePrefImpl
import com.hasankcay.base.base_local.datastore.IDataStorePref
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Singleton
    @Provides
    fun provideDataStoreInstance(
        @ApplicationContext context: Context,
        moshi: Moshi
    ): IDataStorePref {
        return DataStorePrefImpl(context, moshi)
    }

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder().build()
    }
}