package com.hasankcay.base.base_local.datastore

import android.content.Context
import android.location.Location
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class DataStorePrefImpl @Inject constructor(
    context: Context,
    moshi: Moshi
) : IDataStorePref {

    companion object {
        private val Context.dataStore by preferencesDataStore(
            name = "local_helper"
        )
    }

    private object PreferencesKey {
        val AUTHORIZATION_PREF_HELPER = stringPreferencesKey("authorizationPref")
        val LANGUAGE_PREF_HELPER = stringPreferencesKey("languagePref")
        val USER_ID_PREF_HELPER = stringPreferencesKey("userIdPref")
        val PREF_KEY_LOCATION = stringPreferencesKey("PREF_KEY_LOCATION")
        val PREF_KEY_PHONE_NUMBER = stringPreferencesKey("PREF_KEY_PHONE_NUMBER")
    }

    private var dataStore: DataStore<Preferences> = context.dataStore
    private val adapter: JsonAdapter<Location> = moshi.adapter(Location::class.java)

    override suspend fun saveAuthorizationToken(
        authorizationToken: String
    ) {
        dataStore.edit { pref ->
            pref[PreferencesKey.AUTHORIZATION_PREF_HELPER] = authorizationToken
        }
    }

    override suspend fun getAuthorizationToken(): String {
        return dataStore.data.catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map {
            it[PreferencesKey.AUTHORIZATION_PREF_HELPER]
        }.first() ?: ""
    }

    override suspend fun saveLanguage(language: String) {
        dataStore.edit { pref ->
            pref[PreferencesKey.LANGUAGE_PREF_HELPER] = language
        }
    }

    override suspend fun getLanguage(): String {
        return dataStore.data.catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map {
            it[PreferencesKey.LANGUAGE_PREF_HELPER]
        }.first() ?: "en"
    }

    override suspend fun saveUserId(userId: String) {
        dataStore.edit {
            it[PreferencesKey.USER_ID_PREF_HELPER] = userId
        }
    }


    override suspend fun getUserId(): String {
        return dataStore.data.catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map {
            it[PreferencesKey.USER_ID_PREF_HELPER]
        }.first() ?: ""
    }

    override suspend fun saveLocation(location: Location) {
        dataStore.edit {
            it[PreferencesKey.PREF_KEY_LOCATION] = adapter.toJson(location)
        }
    }

    override suspend fun getLocation(): Location {
        return dataStore.data.catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map {
            it[PreferencesKey.PREF_KEY_LOCATION]?.let { locationString ->
                kotlin.runCatching {
                    adapter.fromJson(locationString)
                }.getOrNull()
            }
        }.first() ?: Location("")

    }

    override suspend fun logout() {
        dataStore.edit {
            it.clear()
        }
    }

    override suspend fun savePhoneNumber(phoneNumber: String) {
        dataStore.edit {
            it[PreferencesKey.PREF_KEY_PHONE_NUMBER] = phoneNumber
        }
    }

    override suspend fun getPhoneNumber(): String {
        return dataStore.data.catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map {
            it[PreferencesKey.PREF_KEY_PHONE_NUMBER]
        }.first() ?: ""

    }


}