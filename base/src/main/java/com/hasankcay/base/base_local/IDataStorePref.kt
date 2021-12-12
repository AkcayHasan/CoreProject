package com.hasankcay.base.base_local

import android.location.Location
import kotlinx.coroutines.flow.Flow


interface IDataStorePref {
    /**
     * Authorization Key'i kaydetmek için kullanılır
     * @param authorizationToken: Kaydedilen authorization key değeridir
     */
    suspend fun saveAuthorizationToken(authorizationToken: String)

    /**
     * Kaydedilen authorization keyi döner
     */
    suspend fun getAuthorizationToken(): Flow<String>

    /**
     * Değiştirilmek istenen language'i kaydetmek için kullanılır
     * @param language: Kaydedilen language değeridir
     */
    suspend fun saveLanguage(language: String)

    /**
     * Kaydedilen language'i döner
     */
    suspend fun getLanguage(): Flow<String>

    /**
     * User id'yi kaydetmek için kullanılır
     * @param userId: Kaydedilen user id değeLocalModulesridir
     */
    suspend fun saveUserId(userId: String)

    /**
     * Kaydedilen user id'yi döner
     */
    suspend fun getUserId(): Flow<String>

    /**
     * Kullanıcının lokasyonunu kaydetmek için kullanılır
     * @param location: Kaydedilmek istenen lokasyondur
     */
    suspend fun saveLocation(location: Location)

    /**
     * Kaydedilen son lokasyonu geri döner
     */
    suspend fun getLocation(): Flow<Location>

    /**
     * Tüm kaydedilen değerleri silmek için kullanılır
     */
    suspend fun logout()

    /**
     * Telefon numarasını silmek için kullanılır
     * @param phoneNumber: Kaydedilmek istenen telefon numarasıdır
     */
    suspend fun savePhoneNumber(phoneNumber: String)

    /**
     * Kaydedilen telefon numarasını döner
     */
    suspend fun getPhoneNumber(): Flow<String>

}
