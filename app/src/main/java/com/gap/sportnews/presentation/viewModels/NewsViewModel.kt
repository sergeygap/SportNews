package com.gap.sportnews.presentation.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gap.sportnews.data.repository.NewsRepositoryImpl
import com.gap.sportnews.domain.GetListNewsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    private val repository = NewsRepositoryImpl()
    private val getListUseCase = GetListNewsUseCase(repository)

    fun test() {
            viewModelScope.launch {
                val listNews = getListUseCase()
                Log.d("NewsViewModel", listNews.size.toString())
            }
    }
}