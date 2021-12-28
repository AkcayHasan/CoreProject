package com.hasankcay.base.base_extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.hideKeyboard() {
    val inputMethod: InputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethod.hideSoftInputFromWindow(windowToken, 0)
}

fun View.showKeyboard() {
    val inputMethod: InputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethod.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}
fun View.isVisible() = this.visibility == View.VISIBLE