package com.hasankcay.base.base_entity

import com.squareup.moshi.Json

data class ErrorResponse(
    @Json(name = "status_code")
    val status: Int,
    @Json(name = "status_message")
    val message: String
)
