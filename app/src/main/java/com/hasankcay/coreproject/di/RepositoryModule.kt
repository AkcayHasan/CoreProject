package com.hasankcay.coreproject.di

import com.hasankcay.coreproject.features.movies.data.api.MovieService
import com.hasankcay.coreproject.features.movies.data.repository.MoviesRepositoryImpl
import com.hasankcay.coreproject.features.movies.domain.repository.IMoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMoviesRepo(
        service: MovieService
    ): IMoviesRepository {
        return MoviesRepositoryImpl(service)
    }

}