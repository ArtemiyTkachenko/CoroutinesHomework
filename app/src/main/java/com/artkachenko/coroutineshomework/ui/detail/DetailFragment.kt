package com.artkachenko.coroutineshomework.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.artkachenko.coroutineshomework.R
import com.artkachenko.coroutineshomework.base.BaseFragment
import com.artkachenko.coroutineshomework.databinding.DetailFragmentBinding
import com.artkachenko.coroutineshomework.utils.loadImage
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DetailFragment : BaseFragment(R.layout.detail_fragment) {

    private val viewModel by viewModels<DetailViewModel>()

    private val movieId by lazy {
        arguments?.getLong("movieId")
    }

    private lateinit var binding: DetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieId?.let { viewModel.getMovieDetail(it) }

        scope.launch {
            viewModel.movie.collect { movie ->
                movie?.let {
                    with(binding) {
                        it.posterPath?.let { image.loadImage(it) }
                        title.text = it.title
                        overview.text = it.overview
                        rating.text = "Rating: ${it.voteAverage}"
                        ratingCount.text = "Count: ${it.voteCount}"
                    }
                }
            }
        }
    }
}