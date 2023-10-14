package com.gap.sportnews.presentation.viewModels

import androidx.lifecycle.ViewModel
import com.gap.sportnews.data.NewsRepositoryImpl
import com.gap.sportnews.domain.GetListNewsUseCase
import com.gap.sportnews.domain.NewsRepository

class NewsViewModel: ViewModel() {
    private val repository = NewsRepositoryImpl()
    private val getListUseCase = GetListNewsUseCase(repository)

    fun test() {
        val listNews = getListUseCase.invoke()
    }
}