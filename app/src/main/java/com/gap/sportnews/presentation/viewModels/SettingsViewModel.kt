package com.gap.sportnews.presentation.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gap.sportnews.data.repository.NewsRepositoryImpl
import com.gap.sportnews.domain.AddFavouritesUseCase
import com.gap.sportnews.domain.DeleteAllFavouritesUseCase
import com.gap.sportnews.domain.DeleteFavouritesUseCase
import com.gap.sportnews.domain.GetNewsDetailsUseCase
import com.gap.sportnews.domain.News
import kotlinx.coroutines.launch

class SettingsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = NewsRepositoryImpl(application)
    private val deleteAllFavouritesUseCase = DeleteAllFavouritesUseCase(repository)

    fun deleteAllFavourites() {
        viewModelScope.launch {
            deleteAllFavouritesUseCase()
        }
    }
}