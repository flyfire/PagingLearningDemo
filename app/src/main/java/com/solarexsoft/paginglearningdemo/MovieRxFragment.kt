package com.solarexsoft.paginglearningdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.solarexsoft.paginglearningdemo.databinding.FragmentMovieListBinding
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by houruhou on 2022/2/9/5:11 PM
 * Desc:
 */
class MovieRxFragment : Fragment() {
    private val compositeDisposable = CompositeDisposable()

    private lateinit var binding: FragmentMovieListBinding
    private lateinit var viewModel: GetMoviesRxViewModel
    private lateinit var adapter: MoviesRxAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieListBinding.inflate(inflater, container, false)

        adapter = MoviesRxAdapter()

        val viewRoot = binding.root

        binding.list.layoutManager = GridLayoutManager(viewRoot.context, 2)
        binding.list.adapter = adapter

        viewModel = ViewModelProvider(this,
            Injection.provideRxViewModel()
        ).get(GetMoviesRxViewModel::class.java)

        return viewRoot
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        compositeDisposable.add(viewModel.getFavoriteMovies().subscribe {
            adapter.submitData(lifecycle, it)
        })
    }

    override fun onDestroyView() {
        compositeDisposable.dispose()

        super.onDestroyView()
    }
}