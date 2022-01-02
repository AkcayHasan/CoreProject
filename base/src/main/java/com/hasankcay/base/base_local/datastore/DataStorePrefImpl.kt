package com.hasankcay.base.base_local.datastore

import android.content.Context
import android.location.Location
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class DataStorePrefImpl @Inject constructor(
    context: Context,
    private val gson: Gson
) : IDataStorePref {

    companion object {
        private val Context.dataStore by preferencesDataStore(
            name = "local_helper"
        )
    }

    private val AUTHORIZATON_PREF_HELPER = stringPreferencesKey("authorizationPref")
    private val LANGUAGE_PREF_HELPER = stringPreferencesKey("languagePref")
    private val USER_ID_PREF_HELPER = stringPreferencesKey("userIdPref")
    private val PREF_KEY_LOCATION = stringPreferencesKey("PREF_KEY_LOCATION")
    private val PREF_KEY_PHONE_NUMBER = stringPreferencesKey("PREF_KEY_PHONE_NUMBER")

    var dataStore: DataStore<Preferences> = context.dataStore

    override suspend fun saveAuthorizationToken(
        authorizationToken: String
    ) {
        dataStore.edit { pref ->
            pref[AUTHORIZATON_PREF_HELPER] = authorizationToken
        }
    }

    override suspend fun getAuthorizationToken(): Flow<String> {
        return flow {
            dataStore.data.catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map {
                it[AUTHORIZATON_PREF_HELPER] ?: ""
            }
        }
    }

    override suspend fun saveLanguage(language: String) {
        dataStore.edit { pref ->
            pref[LANGUAGE_PREF_HELPER] = language
        }
    }

    override suspend fun getLanguage(): Flow<String> {
        return flow {
            dataStore.data.catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map {
                it[LANGUAGE_PREF_HELPER] ?: ""
            }
        }
    }

    override suspend fun saveUserId(userId: String) {
        dataStore.edit {
            it[USER_ID_PREF_HELPER] = userId
        }
    }

    override suspend fun getUserId(): Flow<String> {
        return flow {
            dataStore.data.catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map {
                it[USER_ID_PREF_HELPER] ?: ""
            }
        }
    }

    override suspend fun saveLocation(location: Location) {
        dataStore.edit {
            it[PREF_KEY_LOCATION] = gson.toJson(location)
        }
    }

    override suspend fun getLocation(): Flow<Location> {
        return flow {
            dataStore.data.catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map {
                gson.fromJson(it[PREF_KEY_LOCATION], Location::class.java)
            }
        }
    }

    override suspend fun logout() {
        dataStore.edit {
            it.clear()
        }
    }

    override suspend fun savePhoneNumber(phoneNumber: String) {
        dataStore.edit {
            it[PREF_KEY_PHONE_NUMBER] = phoneNumber
        }
    }

    override suspend fun getPhoneNumber(): Flow<String> {
        return flow {
            dataStore.data.catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map {
                it[PREF_KEY_PHONE_NUMBER] ?: ""
            }
        }
    }


}