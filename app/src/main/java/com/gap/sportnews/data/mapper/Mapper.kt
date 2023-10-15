package com.gap.sportnews.data.mapper

import com.gap.sportnews.data.network.model.NewsDto
import com.gap.sportnews.domain.News
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale

class Mapper {
    fun mapDtoEntity(dto: NewsDto): News {
        val postedTime: String = mapTimeStampToDateTime(dto.postedTime)
        return News(
            dto.id,
            dto.title,
            dto.commentCount,
            dto.socialImage,
            postedTime,
            dto.content
        )
    }

    private fun mapTimeStampToDateTime(postedTime: Long): String {
        val instant = Instant.ofEpochSecond(postedTime)
        val zoneId = ZoneId.of(REGION)
        val formatter = DateTimeFormatter.ofPattern(DATA_PATTERN)
            .withZone(zoneId)
        return formatter.format(instant)
    }

    companion object {
        private const val REGION = "Europe/Moscow"
        private const val DATA_PATTERN = "HH:mm dd.MM.yyyy"
    }
}