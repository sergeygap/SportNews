package com.gap.sportnews.domain

class AddFavouritesUseCase(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(id: Long) {
        repository.addFavorites(id)
    }
}