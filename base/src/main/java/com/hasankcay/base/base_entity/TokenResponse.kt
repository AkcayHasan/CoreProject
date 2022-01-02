package com.hasankcay.base.base_entity

import com.squareup.moshi.Json

data class TokenResponse(
    @Json(name = "success")
    val success: Boolean,
    @Json(name = "expires_at")
    val expiresAt: String,
    @Json(name = "request_token")
    val requestToken: String
)
