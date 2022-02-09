package com.solarexsoft.paginglearningdemo

import android.net.Uri

/**
 * Created by houruhou on 2022/2/9/3:58 PM
 * Desc:
 */
data class Image(val url: String) {
    companion object {
        private const val PATH = "https://image.tmdb.org/t/p"
    }

    val small: Uri = Uri.parse("$PATH/w92/$url")

    val medium: Uri = Uri.parse("$PATH/w185/$url")

    val large: Uri = Uri.parse("$PATH/w342/$url")

    val original: Uri = Uri.parse("$PATH/original/$url")
}