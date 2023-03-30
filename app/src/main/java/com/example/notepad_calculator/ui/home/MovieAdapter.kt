package com.example.notepad_calculator.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notepad_calculator.R
import kotlinx.android.synthetic.main.list_item.view.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    var movies: MutableList<Moviee> = mutableListOf()

    init { refreshMovies() }

    class MovieViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MovieViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.view.name.text = movies[position].toString()
    }

    override fun getItemCount() = movies.size

    fun refreshMovies() {
        movies.clear()

        movies.add(Moviee(0,"Guardians of the Galaxy"))
        movies.add(Moviee(1, "Avengers: Infinity War"))
        movies.add(Moviee(2,"Thor: Ragnorok"))
        Log.d("debuggeando", "refreshMovies")
        notifyDataSetChanged()
    }
}
