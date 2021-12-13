package com.hasankcay.base.base_extensions

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun String.timeFormat(): String {
    var timeInstance : Date ?= null
    var formattedTime = ""
    val timeFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
    val output = SimpleDateFormat("h:mm a")

    try {
        timeInstance = timeFormat.parse(this)
    }catch (ex: Exception){
        ex.printStackTrace()
    }
    timeInstance?.let {
        formattedTime = output.format(it)
    }
    return formattedTime
}

@SuppressLint("SimpleDateFormat")
fun String.dateFormat(): String {
    var dateInstance : Date ?= null
    var formattedDate = ""
    val dateFormat = SimpleDateFormat("yyyy-MM-dd")
    val output = SimpleDateFormat("EEE, MMM d")

    try {
        dateInstance = dateFormat.parse(this)
    }catch (ex: Exception){
        ex.printStackTrace()
    }
    dateInstance?.let {
        formattedDate = output.format(it)
    }
    return formattedDate
}