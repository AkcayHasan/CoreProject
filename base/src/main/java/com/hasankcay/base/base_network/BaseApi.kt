package com.hasankcay.base.base_network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface BaseApi {

    @GET("")
    suspend fun getAuthToken(): Response<String>

    @POST("")
    suspend fun updateData()
}