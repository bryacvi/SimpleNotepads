package com.example.simple_notepads.examples.movie

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.simple_notepads.R
import com.example.simple_notepads.examples.word.Word

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    var movies: MutableList<Moviee> = mutableListOf()
    var moviesAux: MutableList<Moviee> = mutableListOf()
    private var count = 0

    init { refreshMovies() }

    class MovieViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MovieViewHolder {

        Log.d("debuggeando", "refreshMovies")
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
//        holder.view.name.text = movies[position].name
    }

    override fun getItemCount() = movies.size

    fun refreshMovies() {
        moviesAux = movies
        count = itemCount
        movies.clear()

        for (i in moviesAux.indices) {
            movies[i] = moviesAux[i]
            addMovie(movies[i].toString())
        }
        moviesAux.clear()
    }

    fun addMovie(name: String) {
        movies.add(Moviee(itemCount-1, name))
        notifyDataSetChanged()
    }

    fun deleteMovie(movie: Moviee) {

    }

    companion object {
        private val WORDS_COMPARATOR = object : DiffUtil.ItemCallback<Word>() {
            override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
                return oldItem.word == newItem.word
            }
        }
    }
}
