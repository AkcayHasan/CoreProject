package com.hasankcay.base.base_network

import com.hasankcay.base.base_network.util.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class UseCase<out Type : Any, in Params> {

    protected abstract suspend fun buildUseCase(params: Params): Type

    suspend fun run(params: Params): Either<Failure, Type> = withContext(Dispatchers.IO) {
        try {
            Either.Right(buildUseCase(params))
        } catch (failure: Failure) {
            Either.Left(failure)
        }
    }

    object None {
        override fun toString(): String = "UseCase.None"
    }
}