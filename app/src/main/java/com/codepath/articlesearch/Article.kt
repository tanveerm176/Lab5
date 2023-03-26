package com.codepath.articlesearch

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
//note: all notes provided from https://courses.codepath.org/courses/and102/unit/5#!labs

//note: SQLite is a open source SQL database that stores data to a text file on a device.
// Android comes in with built in SQLite database implementation, but working directly
// with SQLite can be quite verbose so the Room persistence library
// provides an abstraction layer over SQLite to allow easier database access.


@Keep
@Serializable
data class SearchNewsResponse(
    @SerialName("response")
    val response: BaseResponse?
)

@Keep
@Serializable
data class BaseResponse(
    @SerialName("docs")
    val docs: List<Article>?
)

@Keep
@Serializable
data class Article(
    @SerialName("web_url")
    val webUrl: String?,
    @SerialName("pub_date")
    val pubDate: String?,
    @SerialName("headline")
    val headline: HeadLine?,
    @SerialName("multimedia")
    val multimedia: List<MultiMedia>?,
    @SerialName("abstract")
    val abstract: String?,
    @SerialName("byline")
    val byline: Byline?,
) : java.io.Serializable {
    val mediaImageUrl =
        "https://www.nytimes.com/${multimedia?.firstOrNull { it.url != null }?.url ?: ""}"
}

@Keep
@Serializable
data class HeadLine(
    @SerialName("main")
    val main: String
) : java.io.Serializable

@Keep
@Serializable
data class Byline(
    @SerialName("original")
    val original: String? = null
) : java.io.Serializable

@Keep
@Serializable
data class MultiMedia(
    @SerialName("url")
    val url: String?
) : java.io.Serializable