package com.solarexsoft.paginglearningdemo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava2.flowable
import io.reactivex.Flowable

/**
 * Created by houruhou on 2022/2/9/4:06 PM
 * Desc:
 */
interface GetMoviesRxRepository {
    fun getMovies(): Flowable<PagingData<Movies.Movie>>
}

class GetMoviesRxRepositoryImpl(private val pagingSource: GetMoviesRxPagingSource):
    GetMoviesRxRepository {

    override fun getMovies(): Flowable<PagingData<Movies.Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = true,
                maxSize = 30,
                prefetchDistance = 5,
                initialLoadSize = 40),
            pagingSourceFactory = { pagingSource }
        ).flowable
    }
}