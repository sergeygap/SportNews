package com.gap.sportnews.domain

class DeleteFavouritesUseCase(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(id: Long) {
        repository.deleteFavorites(id)
    }
}