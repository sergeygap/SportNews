package com.gap.sportnews.presentation.viewModels

import androidx.lifecycle.ViewModel
import com.gap.sportnews.data.repository.NewsRepositoryImpl
import com.gap.sportnews.domain.GetListNewsUseCase

class NewsViewModel: ViewModel() {
    private val repository = NewsRepositoryImpl()
    private val getListUseCase = GetListNewsUseCase(repository)

    fun test() {
        val listNews = getListUseCase.invoke()
    }
}