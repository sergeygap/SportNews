package com.gap.sportnews.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gap.sportnews.R
import com.gap.sportnews.data.repository.NewsRepositoryImpl
import com.gap.sportnews.databinding.ActivityMainBinding
import com.gap.sportnews.domain.GetListNewsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        with(binding) {
            actionsNews.setOnClickListener {
                actionsSettings.setImageResource(R.drawable.button_settings)
                actionsFavorites.setImageResource(R.drawable.button_favorites)
                actionsNews.setImageResource(R.drawable.button_news_selected)
            }
            actionsFavorites.setOnClickListener {
                actionsSettings.setImageResource(R.drawable.button_settings)
                actionsFavorites.setImageResource(R.drawable.button_favorites_selected)
                actionsNews.setImageResource(R.drawable.button_news)
            }
            actionsSettings.setOnClickListener {
                actionsSettings.setImageResource(R.drawable.button_settings_selected)
                actionsFavorites.setImageResource(R.drawable.button_favorites)
                actionsNews.setImageResource(R.drawable.button_news)
            }
        }

    }
}