package com.example.simple_notepads.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.simple_notepads.R
import com.example.simple_notepads.ui.noteManagement.Word
import kotlinx.android.synthetic.main.list_item.view.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    var movies: MutableList<Moviee> = mutableListOf()

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
        holder.view.name.text = movies[position].name
    }

    override fun getItemCount() = movies.size

    fun refreshMovies() {
        movies.clear()

        movies.add(Moviee(0,"Guardians of the Galaxy"))
        movies.add(Moviee(1, "Avengers: Infinity War"))
        movies.add(Moviee(2,"Thor: Ragnorok"))
        notifyDataSetChanged()
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
