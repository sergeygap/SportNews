package com.gap.sportnews.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gap.sportnews.data.repository.NewsRepositoryImpl
import com.gap.sportnews.domain.GetNewsDetailsUseCase
import com.gap.sportnews.domain.News
import kotlinx.coroutines.launch

class NewsDetailsViewModel : ViewModel() {
    private val repository = NewsRepositoryImpl()
    private val getNewsDetailsUseCase = GetNewsDetailsUseCase(repository)

    private val _newsLD = MutableLiveData<News>()
    val newLD: LiveData<News>
        get() = _newsLD

    fun loadData(id: Int) {
        viewModelScope.launch {
            val news = getNewsDetailsUseCase(id)
            _newsLD.postValue(news)
            Log.d("NewsDetailsViewModel", news.content)
        }
    }
}