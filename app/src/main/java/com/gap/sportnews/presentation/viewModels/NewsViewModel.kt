package com.gap.sportnews.presentation.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gap.sportnews.data.repository.NewsRepositoryImpl
import com.gap.sportnews.domain.GetListNewsUseCase
import com.gap.sportnews.domain.News
import kotlinx.coroutines.launch

class NewsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = NewsRepositoryImpl(application)
    private val getListUseCase = GetListNewsUseCase(repository)
    private var from = 0
    private var count = 10
    private val _newsLD = MutableLiveData<List<News>>()

    val newsLD: LiveData<List<News>>
        get() = _newsLD

    fun getNewsList() {
        viewModelScope.launch {
            val loadedNewsList = newsLD.value?.toMutableList()
            if (loadedNewsList != null) {
                loadedNewsList.addAll(getListUseCase(from, count))
                _newsLD.postValue(loadedNewsList)
            } else {
                _newsLD.postValue(getListUseCase(from, count))
            }
            upPage()
        }
    }

    fun updateNewsList() {
        from = 0
        _newsLD.value = emptyList()
        getNewsList()
    }

    private fun upPage() {
        this.from = from + 10
    }
}