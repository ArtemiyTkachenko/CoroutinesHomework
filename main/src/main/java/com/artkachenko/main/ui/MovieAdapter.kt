package com.artkachenko.main.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artkachenko.core_api.dto.Movie
import com.artkachenko.main.R
import com.artkachenko.main.databinding.MovieListItemBinding
import com.artkachenko.utils.loadImage
import com.artkachenko.utils.setSingleClickListener

class MovieAdapter(private val callbacks: MainFragmentCallbacks) : RecyclerView.Adapter<MovieViewHolder>() {

    private val items = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(items[position], callbacks)
    }

    override fun getItemCount() = items.size

    fun setData(data: List<Movie>) {
        val start = items.size
        items.addAll(data)
        notifyItemRangeChanged(start, start + data.size - 1)
    }
}

class MovieViewHolder(private val binding: MovieListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie, callbacks: MainFragmentCallbacks) {
        with (binding) {
            movie.posterPath?.let { posterImage.loadImage(it, placeholderRes = R.drawable.ic_film) }
            movie.title?.let { title.text = it }
            container.setSingleClickListener {
                callbacks.getMovieDetails(movie)
            }
        }
    }
}