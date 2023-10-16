package com.gap.sportnews.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.gap.sportnews.R
import com.gap.sportnews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var savedInstanceState: Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.savedInstanceState = savedInstanceState
        setContentView(binding.root)
        bottomNavigationMenu()
    }


    private fun bottomNavigationMenu() {
        with(binding) {
            actionsNews.setOnClickListener {
                actionsSettings.setImageResource(R.drawable.button_settings)
                actionsFavorites.setImageResource(R.drawable.button_favorites)
                actionsNews.setImageResource(R.drawable.button_news_selected)
                launchFragment(NewsFragment.newInstance())
            }

            actionsFavorites.setOnClickListener {
                actionsSettings.setImageResource(R.drawable.button_settings)
                actionsFavorites.setImageResource(R.drawable.button_favorites_selected)
                actionsNews.setImageResource(R.drawable.button_news)
                launchFragment(FavouritesFragment.newInstance())
            }
            actionsSettings.setOnClickListener {
                actionsSettings.setImageResource(R.drawable.button_settings_selected)
                actionsFavorites.setImageResource(R.drawable.button_favorites)
                actionsNews.setImageResource(R.drawable.button_news)
                launchFragment(SettingsFragment.newInstance())
            }
        }
    }

    private fun launchFragment(fragment: Fragment) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, fragment)
                .commit()
        }
    }


    override fun onBackPressed() {
        val constraintLayout = findViewById<ConstraintLayout>(R.id.bottomNavigationView)
        constraintLayout.visibility = View.VISIBLE
        super.onBackPressed()
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}