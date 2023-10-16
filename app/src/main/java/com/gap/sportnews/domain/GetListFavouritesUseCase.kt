package com.gap.sportnews.domain

class GetListFavouritesUseCase(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(): List<Favourites> {
        return repository.getListFavorites()
    }
}