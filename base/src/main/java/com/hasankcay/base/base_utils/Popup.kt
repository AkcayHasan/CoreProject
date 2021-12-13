package com.hasankcay.base.base_utils

import android.app.AlertDialog
import android.content.Context

class Popup(
    context: Context,
    private val model: PopupModel,
    private val listener: PopupListener? = null
) {

    private val alertDialog = AlertDialog.Builder(context)

    init {
        with(alertDialog) {
            model.title?.let { setTitle(it) }
            model.message?.let { setMessage(it) }

            val cancellable = model.cancelable || listener == null

            setCancelable(cancellable)
            setButtons()
        }
    }

    private fun setButtons() = with(alertDialog) {
        val resources = this.context.resources
        listener?.let {
            val positiveButtonText = model.positiveButtonText ?: "Yes"
            val negativeButtonText = model.negativeButtonText ?: "No"

            it.setPositiveButtonClick?.let {
                setPositiveButton(positiveButtonText) { _, _ -> it.invoke() }
            }
            it.setNegativeButtonClick?.let {
                setNegativeButton(negativeButtonText) { _, _ -> it.invoke()}
            }
        }
    }

    fun show(): AlertDialog = alertDialog.show()

}