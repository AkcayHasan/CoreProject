package com.hasankcay.coreproject.features.movies.domain.repository

import com.hasankcay.base.base_network.ResultWrapper
import com.hasankcay.coreproject.features.movies.data.entities.MoviesResponse

interface IMoviesRepository {
    suspend fun getTopRatedMovies(): ResultWrapper<MoviesResponse>
}