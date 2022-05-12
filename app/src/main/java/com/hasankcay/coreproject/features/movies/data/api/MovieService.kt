package com.hasankcay.coreproject.features.movies.data.api

import com.hasankcay.coreproject.features.movies.data.entities.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("page") page: Int
    ): MoviesResponse
}