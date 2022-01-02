package com.hasankcay.base.base_network

data class CoreDataState<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T?): CoreDataState<T> = CoreDataState(Status.SUCCESS, data, null)
        fun <T> error(msg: String, data: T?): CoreDataState<T> = CoreDataState(Status.ERROR, data, msg)
        fun <T> loading(data: T?): CoreDataState<T> = CoreDataState(Status.LOADING, data, null)
    }

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

}

