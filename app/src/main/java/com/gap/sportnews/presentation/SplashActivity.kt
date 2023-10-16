package com.gap.sportnews.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.gap.sportnews.R

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startActivity()
    }

    private fun startActivity() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo

        if (networkInfo != null && networkInfo.isConnected) {
            Handler(Looper.getMainLooper()).postDelayed({
                startMainActivity()
                finish()
            }, 1000)
        } else {
            showNoInternetDialog()
        }
    }

    private fun startMainActivity() {
        val intent = MainActivity.newIntent(this)
        startActivity(intent)
    }

    private fun showNoInternetDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Нет соединения с интернетом")
        builder.setMessage("Проверьте настройки сети и попробуйте еще раз")
        builder.setPositiveButton("Повторить") { _, _ ->
            startActivity()
        }

        builder.setOnCancelListener {
            finish()
        }

        builder.setCancelable(false)
        builder.show()
    }
}
