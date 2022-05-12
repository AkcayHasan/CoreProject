package com.hasankcay.coreproject.features.movies.data.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviesResponse(
    @field:Json(name = "results")
    val results: List<MoviesResponseModel>
)
