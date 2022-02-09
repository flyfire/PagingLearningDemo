package com.solarexsoft.paginglearningdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.solarexsoft.paginglearningdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = MoviesRxAdapter()
        binding.list.adapter = adapter
        val viewModel = ViewModelProvider(this, Injection.provideRxViewModel()).get(GetMoviesRxViewModel::class.java)
        viewModel.getFavoriteMovies()
            .subscribe(
                { pagingData ->
                    adapter.submitData(lifecycle, pagingData)
                },
                {
                    it.printStackTrace()
                }
            )
    }
}