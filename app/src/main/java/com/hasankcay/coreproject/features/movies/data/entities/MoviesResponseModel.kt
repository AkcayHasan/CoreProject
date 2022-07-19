package com.hasankcay.coreproject.features.movies.data.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviesResponseModel(
    @field:Json(name = "posterPath")
    val posterPath: String?,
    @field:Json(name = "adult")
    val adult: Boolean,
    @field:Json(name = "overview")
    val overview: String,
    @field:Json(name = "releaseDate")
    val releaseDate: String,
    @field:Json(name = "genreIds")
    val genreIds: List<Int>,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "originalTitle")
    val originalTitle: String,
    @field:Json(name = "originalLanguage")
    val originalLanguage: String,
    @field:Json(name = "title")
    val title: String,
    @field:Json(name = "backdropPath")
    val backdropPath: String?,
    @field:Json(name = "popularity")
    val popularity: Double,
    @field:Json(name = "voteCount")
    val voteCount: Int,
    @field:Json(name = "video")
    val video: Boolean,
    @field:Json(name = "voteAverage")
    val voteAverage: Double
)
