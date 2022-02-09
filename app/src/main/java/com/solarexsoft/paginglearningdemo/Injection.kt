package com.solarexsoft.paginglearningdemo

import androidx.lifecycle.ViewModelProvider
import java.util.*

/**
 * Created by houruhou on 2022/2/9/5:19 PM
 * Desc:
 */
object Injection {
    fun provideLocale(): Locale = Locale.getDefault()

    fun provideRxViewModel(): ViewModelProvider.Factory {
        val pagingSource =
            GetMoviesRxPagingSource(
                service = TMDBService.create(),
                apiKey = "21440930b1350cd8b4d28accce3a4799",
                mapper = MoviesMapper(),
                locale = provideLocale()
            )
        val repository =
            GetMoviesRxRepositoryImpl(
                pagingSource = pagingSource
            )

        return GetMoviesRxViewModelFactory(repository)
    }
}