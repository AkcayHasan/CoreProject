package com.hasankcay.base.base_network.api

import com.hasankcay.base.base_entity.ErrorResponse
import com.hasankcay.base.base_entity.TokenResponse
import com.hasankcay.base.base_network.NetworkResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface BaseApi {

    @GET("")
    suspend fun getAuthToken(): NetworkResponse<TokenResponse, ErrorResponse>

    @POST("")
    suspend fun updateData()
}