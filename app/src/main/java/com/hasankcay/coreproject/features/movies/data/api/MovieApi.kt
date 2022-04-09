package com.hasankcay.coreproject.features.movies.data.api

import com.hasankcay.coreproject.features.movies.data.entities.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Response<List<MoviesResponse>>
}