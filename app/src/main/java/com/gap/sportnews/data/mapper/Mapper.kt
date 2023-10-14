package com.gap.sportnews.data.mapper

import com.gap.sportnews.data.network.model.NewsDto
import com.gap.sportnews.domain.News

class Mapper {
    fun mapDtoEntity(dto: NewsDto): News {
        return News(
            dto.id,
            dto.title,
            dto.comment_count,
            dto.social_image,
            dto.posted_time,
            dto.content
        )
    }
}