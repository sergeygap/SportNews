package com.gap.sportnews.presentation.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gap.sportnews.data.repository.NewsRepositoryImpl
import com.gap.sportnews.domain.AddFavouritesUseCase
import com.gap.sportnews.domain.CheckIdUseCase
import com.gap.sportnews.domain.DeleteFavouritesUseCase
import com.gap.sportnews.domain.GetNewsDetailsUseCase
import com.gap.sportnews.domain.News
import kotlinx.coroutines.launch

class NewsDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = NewsRepositoryImpl(application)
    private val getNewsDetailsUseCase = GetNewsDetailsUseCase(repository)
    private val addFavouritesUseCase = AddFavouritesUseCase(repository)
    private val deleteFavouritesUseCase = DeleteFavouritesUseCase(repository)
    private val checkIdUseCase = CheckIdUseCase(repository)

    private val _newsLD = MutableLiveData<News>()
    val newLD: LiveData<News>
        get() = _newsLD

    private val _favouriteStateLD = MutableLiveData<Boolean>()
    val favouriteStateLD: LiveData<Boolean>
        get() = _favouriteStateLD

    fun loadData(id: Int) {
        viewModelScope.launch {
            val news = getNewsDetailsUseCase(id)
            _newsLD.postValue(news)
            Log.d("NewsDetailsViewModel", news.content)
        }
    }

    fun checkId(id: Int) {
        viewModelScope.launch {
            _favouriteStateLD.value = checkIdUseCase(id)
        }
    }

    fun addToDb(id: Long) {
        viewModelScope.launch {
            addFavouritesUseCase(id)
        }
    }

    fun deleteInDb(id: Long) {
        viewModelScope.launch {
            deleteFavouritesUseCase(id)
        }
    }
}