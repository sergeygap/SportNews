package com.gap.sportnews.domain

class GetNewsDetailsUseCase(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(id: Int): News {
        return repository.getNewsDetails(id)
    }
}