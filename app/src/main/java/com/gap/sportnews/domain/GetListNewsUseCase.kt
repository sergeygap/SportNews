package com.gap.sportnews.domain


class GetListNewsUseCase(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(from: Int, count: Int): List<News> {
        return repository.getListNews(from, count)
    }
}