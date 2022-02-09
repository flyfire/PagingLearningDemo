package com.solarexsoft.paginglearningdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.filter
import androidx.paging.rxjava2.cachedIn
import io.reactivex.Flowable
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Created by houruhou on 2022/2/9/4:09 PM
 * Desc:
 */
class GetMoviesRxViewModel(private val repository: GetMoviesRxRepository) : ViewModel() {
    @ExperimentalCoroutinesApi
    fun getFavoriteMovies(): Flowable<PagingData<Movies.Movie>> {
        return repository
            .getMovies()
            .map { pagingData -> pagingData.filter { it.poster != null } }
            .cachedIn(viewModelScope)
    }
}