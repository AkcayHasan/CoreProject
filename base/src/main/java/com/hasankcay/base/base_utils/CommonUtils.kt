package com.hasankcay.base.base_utils

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import android.widget.ProgressBar

class CommonUtils {

    companion object {
        /**
         * Used to show LoadingBar
         */
        fun showLoadingBar(c: Context): ProgressBar {
            val progressBar = ProgressBar(c)
/*
            if (!(c as Activity).isFinishing){
                progressBar.visibility = View.VISIBLE
            }
 */
            progressBar.isIndeterminate = true

            return progressBar
        }


        /**
         * Used to get unique DeviceId
         */
        @SuppressLint("HardwareIds")
        fun getUdid(context: Context): String? {
            return Settings.Secure.getString(
                context.contentResolver,
                Settings.Secure.ANDROID_ID
            )
        }


    }
}