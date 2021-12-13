package com.hasankcay.base.base_extensions

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import com.hasankcay.base.base_utils.Popup
import com.hasankcay.base.base_utils.PopupListener
import com.hasankcay.base.base_utils.PopupModel

val Context.connectivityManager: ConnectivityManager
    get() =
        this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

fun Context.toast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, duration).show()
}

fun Context.showPopup(model: PopupModel, listener: PopupListener? = null) {
    Popup(this, model, listener).show()
}