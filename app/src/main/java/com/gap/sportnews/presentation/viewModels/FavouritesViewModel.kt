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
import com.gap.sportnews.domain.GetListFavouritesUseCase
import com.gap.sportnews.domain.GetNewsDetailsUseCase
import com.gap.sportnews.domain.News
import kotlinx.coroutines.launch

class FavouritesViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = NewsRepositoryImpl(application)
    private val getListFavouritesUseCase = GetListFavouritesUseCase(repository)
    private val getNewsDetailsUseCase = GetNewsDetailsUseCase(repository)

    private val _newsLD = MutableLiveData<List<News>>()

    val newsLD: LiveData<List<News>>
        get() = _newsLD

    fun getNewsList() {
        viewModelScope.launch {
            Log.d("getNewsList", "getNewsList is working")
            val list = getListFavouritesUseCase()
//            for (i in list){
//                Log.d("getNewsList", i.id.toString())
//            }

//            val newsList = mutableListOf<News>()
//            for (favourites in list) {
//                newsList.add(getNewsDetailsUseCase(favourites.id))
//            }
//            _newsLD.value = newsList
        }

    }

}