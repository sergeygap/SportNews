package com.gap.sportnews.domain

class GetListFavouritesUseCase(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(): List<Long> {
        return repository.getListFavorites()
    }
}