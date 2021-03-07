package com.artkachenko.coroutineshomework.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.artkachenko.coroutineshomework.MovieApp
import com.artkachenko.coroutineshomework.R
import com.artkachenko.coroutineshomework.base.BaseFragment
import com.artkachenko.coroutineshomework.databinding.MainFragmentBinding
import com.artkachenko.coroutineshomework.di.components.DaggerMainComponent
import com.artkachenko.coroutineshomework.di.components.MainComponent
import com.artkachenko.coroutineshomework.model.Movie
import com.artkachenko.coroutineshomework.utils.onLoadMore
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class MainFragment : BaseFragment(R.layout.main_fragment), MainFragmentCallbacks {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    private val movieAdapter by lazy {
        MovieAdapter(this)
    }

    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        MainComponent.injectFragment(this)
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.recycler) {
            adapter = movieAdapter
            layoutManager = GridLayoutManager(requireContext(), 3)
            onLoadMore {
                viewModel.loadMore()
            }
        }

        scope.launch {
            viewModel.movies.collect {
                movieAdapter.setData(it)
            }
        }
    }

    override fun getMovieDetails(movie: Movie) {
        runCatching {
            val bundle = Bundle().apply {
                putLong("movieId", movie.id ?: -1)
            }
            findNavController().navigate(R.id.main_to_detail, bundle)
        }.onFailure { it.printStackTrace() }
    }
}