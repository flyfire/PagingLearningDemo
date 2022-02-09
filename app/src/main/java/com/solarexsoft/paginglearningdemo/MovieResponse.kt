package com.solarexsoft.paginglearningdemo

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by houruhou on 2022/2/9/3:55 PM
 * Desc:
 */
data class MoviesResponse(
    @SerializedName("total_pages") val total: Int = 0,
    val page: Int = 0,
    val results: List<Movie>
) {

    data class Movie(
        val popularity: Double,
        @SerializedName("vote_count") val voteCount: Int,
        val video: Boolean,
        @SerializedName("poster_path") val posterPath: String?,
        val id: Long,
        val adult: Boolean,
        @SerializedName("backdrop_path") val backdropPath: String?,
        @SerializedName("original_language") val originalLanguage: String,
        @SerializedName("original_title") val originalTitle: String,
        val title: String,
        @SerializedName("vote_average") val voteAverage: Double,
        val overview: String,
        @SerializedName("release_date") val releaseDate: String?
    )
}

data class Movies(
    val total: Int = 0,
    val page: Int = 0,
    val movies: List<Movie>
) {

    val endOfPage = total == page

    data class Movie(
        val id: Long = 0,
        val movieId: Long,
        val popularity: Double,
        val video: Boolean,
        val poster: Image?,
        val adult: Boolean,
        val backdrop: Image?,
        val originalLanguage: String,
        val originalTitle: String,
        val title: String,
        val voteAverage: Double,
        val overview: String,
        val releaseDate: Date?
    )
}