package com.gap.sportnews.domain

class GetNewsUseCase(
    private val repository: NewsRepository
) {
    operator fun invoke(id: Int): News {
        return repository.getNews(id)
    }
}