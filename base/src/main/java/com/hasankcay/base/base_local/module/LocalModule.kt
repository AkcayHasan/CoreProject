package com.hasankcay.base.base_local.module

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.google.gson.Gson
import com.hasankcay.base.base_local.datastore.DataStorePrefImpl
import com.hasankcay.base.base_local.datastore.IDataStorePref
import com.hasankcay.base.base_local.roomdb.database.BaseDatabase
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

    @Provides
    @Singleton
    fun provideBaseDatabase(@ApplicationContext context: Context): BaseDatabase {
        return Room.databaseBuilder(context, BaseDatabase::class.java, "example.db").build()
    }
}