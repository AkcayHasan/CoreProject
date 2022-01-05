package com.hasankcay.base.base_local.roomdb.entity

import com.hasankcay.base.base_entity.Model

data class User(
    val id: String,
    val name: String,
    val email: String
): Model()
