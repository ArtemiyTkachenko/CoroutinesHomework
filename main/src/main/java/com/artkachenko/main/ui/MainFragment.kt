package com.artkachenko.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.artkachenko.core_api.base.BaseFragment
import com.artkachenko.core_api.dto.Movie
import com.artkachenko.main.R
import com.artkachenko.main.databinding.MainFragmentBinding
import com.artkachenko.utils.onLoadMore
import com.artkachenko.main.di.MainComponent
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
//        runCatching {
//            val bundle = Bundle().apply {
//                putLong("movieId", movie.id ?: -1)
//            }
//            findNavController().navigate(R.id.main_to_detail, bundle)
//        }.onFailure { it.printStackTrace() }
    }
}