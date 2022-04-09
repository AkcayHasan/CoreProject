package com.hasankcay.base.base_network

import kotlinx.coroutines.flow.Flow

abstract class BaseUseCase<out Type : Any, in Params> {

    abstract suspend fun execute(params: Params): Flow<Type>
}