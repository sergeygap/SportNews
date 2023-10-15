package com.gap.sportnews.presentation.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gap.sportnews.data.repository.NewsRepositoryImpl
import com.gap.sportnews.domain.GetListNewsUseCase
import com.gap.sportnews.domain.News
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    private val repository = NewsRepositoryImpl()
    private val getListUseCase = GetListNewsUseCase(repository)
    private val _newsLD = MutableLiveData<List<News>>()
    val newsLD: LiveData<List<News>>
        get() = _newsLD

    fun getNewsList() {
            viewModelScope.launch {
                _newsLD.postValue(getListUseCase())
            }
    }
}