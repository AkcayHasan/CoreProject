package com.hasankcay.base.base_local.roomdb.entity

import androidx.room.Entity
import com.squareup.moshi.Json
import javax.inject.Inject

@Entity(tableName = "user", primaryKeys = ["id"])
data class UserEntity(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "email") val email: String
) : ModelEntity() {

    class UserEntityMapper @Inject constructor() : EntityMapper<User, UserEntity> {
        override fun mapToDomain(entity: UserEntity): User = User(
            id = entity.id,
            name = entity.name,
            email = entity.email
        )

        override fun mapToEntity(model: User): UserEntity = UserEntity(
            id = model.id,
            name = model.name,
            email = model.email
        )
    }
}