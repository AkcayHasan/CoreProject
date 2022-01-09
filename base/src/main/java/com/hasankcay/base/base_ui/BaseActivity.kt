package com.hasankcay.base.base_ui

import android.content.Context
import android.content.ContextWrapper
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.google.gson.Gson
import com.hasankcay.base.base_local.datastore.DataStorePrefImpl
import com.hasankcay.base.base_utils.BaseDialogType
import com.hasankcay.base.base_utils.CommonUtils
import com.hasankcay.base.base_utils.LocaleUtils
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import java.util.*

abstract class BaseActivity : AppCompatActivity() {
    var progressBar: ProgressBar? = null
    private lateinit var alertDialog: AlertDialog
    private lateinit var locale: String

    override fun attachBaseContext(base: Context?) {
        val localeUpdatedContext: ContextWrapper? = base?.let {
            val dataStorePrefImpl = DataStorePrefImpl(it, Gson())
            runBlocking {
                locale = dataStorePrefImpl.getLanguage()
            }
            LocaleUtils.updateLocale(
                it,
                Locale(locale)
            )
        }
        super.attachBaseContext(localeUpdatedContext ?: base)
    }

    open fun changeLanguage(language: String) {
        LocaleUtils.updateLocale(this, Locale(language))
        overridePendingTransition(0, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    open fun showLoading() {
        progressBar?.let {
            if (!it.isShown) {
                it.visibility = View.VISIBLE
            }
        } ?: run {
            progressBar = CommonUtils.showLoadingBar(this)
        }
    }

    open fun hideLoading() {
        progressBar?.let {
            if (it.isShown) {
                it.visibility = View.GONE
            }
        }
    }

    open fun showError(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    open fun showInfo(text: String, type: BaseDialogType) {
        // Show an alert dialog with base dialog type
    }

    /*
    private fun hideSystemUI() {
        val decorView: View = this.window.decorView
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else {

            val uiOptions = decorView.systemUiVisibility
            var newUiOptions = uiOptions
            newUiOptions = newUiOptions or View.SYSTEM_UI_FLAG_LOW_PROFILE
            newUiOptions = newUiOptions or View.SYSTEM_UI_FLAG_FULLSCREEN
            newUiOptions = newUiOptions or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            newUiOptions = newUiOptions or View.SYSTEM_UI_FLAG_IMMERSIVE
            newUiOptions = newUiOptions or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            decorView.systemUiVisibility = newUiOptions
        }
    }

    private fun showSystemUI() {
        val decorView: View = this.window.decorView
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(true)
        } else {

            val uiOptions = decorView.systemUiVisibility
            var newUiOptions = uiOptions
            newUiOptions = newUiOptions and View.SYSTEM_UI_FLAG_LOW_PROFILE.inv()
            newUiOptions = newUiOptions and View.SYSTEM_UI_FLAG_FULLSCREEN.inv()
            newUiOptions = newUiOptions and View.SYSTEM_UI_FLAG_HIDE_NAVIGATION.inv()
            newUiOptions = newUiOptions and View.SYSTEM_UI_FLAG_IMMERSIVE.inv()
            newUiOptions = newUiOptions and View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY.inv()
            decorView.systemUiVisibility = newUiOptions
        }
    }

 */

    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

    private fun showSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        WindowInsetsControllerCompat(
            window,
            window.decorView
        ).show(WindowInsetsCompat.Type.systemBars())
    }


}