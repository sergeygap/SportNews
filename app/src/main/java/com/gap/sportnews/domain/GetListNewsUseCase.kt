package com.gap.sportnews.domain

class GetListNewsUseCase(
    private val repository: NewsRepository
) {
    operator fun invoke(): List<News> {
        return repository.getListNews()
    }
}