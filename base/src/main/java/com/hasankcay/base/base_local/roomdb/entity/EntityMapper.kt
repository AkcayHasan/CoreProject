package com.hasankcay.base.base_local.roomdb.entity

import com.hasankcay.base.base_entity.Model

interface EntityMapper<M : Model, ME : ModelEntity> {

    fun mapToDomain(entity: ME): M

    fun mapToEntity(model: M): ME
}