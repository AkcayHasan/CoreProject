package com.hasankcay.base.base_network

sealed class Resource<T> {
    class Success<T>(val data: T) : Resource<T>()
    class Error<T>(val error: Throwable) : Resource<T>()
    class Loading<T>(val isLoading: Boolean) : Resource<T>()
}

