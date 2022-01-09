package com.hasankcay.coreproject.ui.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import androidx.activity.viewModels
import com.hasankcay.coreproject.ui.host.HostActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity: AppCompatActivity() {

    private val viewModel: SplashVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, HostActivity::class.java))
        finish()
    }
}