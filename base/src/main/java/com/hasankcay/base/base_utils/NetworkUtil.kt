package com.hasankcay.base.base_utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

object NetworkUtil {

    fun isNetworkAvailable(c: Context): Boolean {
        var result = false
        val connectivityManager =
            c.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)?.run {
                result = when {
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    else -> false
                }
            }
        } else {
            connectivityManager.activeNetworkInfo?.run {
                result =
                    type == ConnectivityManager.TYPE_WIFI || type == ConnectivityManager.TYPE_MOBILE
            }
        }
        return result
    }
}