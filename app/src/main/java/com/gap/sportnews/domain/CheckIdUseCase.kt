package com.gap.sportnews.domain

class CheckIdUseCase(private val repository: NewsRepository) {
    suspend operator fun invoke(id: Int): Boolean {
        return repository.checkId(id)
    }
}