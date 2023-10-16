package com.gap.sportnews.domain

class DeleteAllFavouritesUseCase(
    private val repository: NewsRepository
) {
    suspend operator fun invoke() {
        repository.deleteAllFavorites()
    }
}