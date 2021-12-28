package com.hasankcay.base.base_extensions

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
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

fun Context.softKeyboard(show: Boolean) {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    when (show) {
        true -> imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        else -> when (this) {
            is Activity -> imm.hideSoftInputFromWindow(this.currentFocus?.windowToken, 0)
            is Fragment -> imm.hideSoftInputFromWindow(activity?.currentFocus?.windowToken, 0)
        }
    }
}