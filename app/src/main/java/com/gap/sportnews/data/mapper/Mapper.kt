package com.gap.sportnews.data.mapper

import android.annotation.SuppressLint
import android.os.Build
import android.text.Html
import com.gap.sportnews.data.database.FavouritesDbModel
import com.gap.sportnews.data.network.model.NewsDto
import com.gap.sportnews.domain.Favourites
import com.gap.sportnews.domain.News
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class Mapper {
    fun mapDtoEntity(dto: NewsDto): News {
        val postedTime: String = mapTimeStampToDateTime(dto.postedTime)
        val content = deleteFromHTML(dto.content)
        val socialImage = if (dto.socialImage == "") {
            "https://photobooth.cdn.sports.ru/preset/news/0/26/330fd1e1244d39f7545da0057004f.jpeg"
        } else {
            dto.socialImage
        }
            return News(
                dto.id,
                dto.title,
                dto.commentCount,
                socialImage,
                postedTime,
                content
            )
    }
    fun mapFavouritesDbModelToFavourites(dbModel: FavouritesDbModel): Favourites {
        return Favourites(dbModel.id)
    }

    private fun deleteFromHTML(content: String): String {
        return if (versionCompat()) {
            cleanString(
                Html.fromHtml(content, Html.FROM_HTML_MODE_LEGACY).toString()
            ).trimStart().trimEnd()
        } else {
            cleanString(Html.fromHtml(content).toString())
                .trimStart().trimEnd()
        }
    }

    private fun cleanString(content: String): String {
        val lastIndex = content.lastIndexOf("})});")
        var finishString = if (lastIndex != -1) {
            content.substring(lastIndex + 5)
        } else {
            content
        }
        finishString = truncateStringToWord(finishString)
        finishString = removeCharacter(finishString)
        return finishString
    }

    private fun removeCharacter(input: String): String {
        val charToRemove = DELETE_CHAR
        val pattern = "\\s*$charToRemove".toRegex()
        return input.replace(pattern, "")
    }

    private fun truncateStringToWord(input: String): String {
        val wordToFind = FINISH_STRING
        val index = input.indexOf(wordToFind)
        return if (index != -1) {
            input.substring(0, index)
        } else {
            input
        }
    }


    @SuppressLint("ObsoleteSdkInt")
    private fun versionCompat() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.N

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
        private const val FINISH_STRING = "Игра: проверьте свою футбольную орфографию"
        private const val DELETE_CHAR = '￼'
    }
}