package com.hasankcay.coreproject.features.movies.data.repository

import com.hasankcay.base.base_network.NetworkCall
import com.hasankcay.base.base_network.ResultWrapper
import com.hasankcay.coreproject.features.movies.data.api.MovieService
import com.hasankcay.coreproject.features.movies.data.entities.MoviesResponse
import com.hasankcay.coreproject.features.movies.domain.repository.IMoviesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val service: MovieService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): IMoviesRepository {
    override suspend fun getTopRatedMovies(): ResultWrapper<MoviesResponse> {
        return NetworkCall.safeApiCall(dispatcher) {service.getTopRatedMovies(1)}
    }
}