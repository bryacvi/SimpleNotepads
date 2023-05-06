/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.simple_notepads.examples.word

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.simple_notepads.R
import com.example.simple_notepads.examples.word.WordListAdapter.WordViewHolder
import com.example.simple_notepads.ui.home.HomeFragment

class WordListAdapter(private val onClickListener: OnClickListener) : ListAdapter<Word, WordViewHolder>(WORDS_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(current)
        }
        holder.bind(current.word)
    }

    class OnClickListener(val clickListener: (word: Word) -> Unit) {
        fun onClick(word: Word) = clickListener(word)
    }

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val wordItemView: TextView = itemView.findViewById(R.id.name)

//        view.findViewById<Button>(R.id.btnDelete)?.setOnClickListener {
//            val txtNoteContent = view?.findViewById<TextView>(R.id.name)
//            val word = txtNoteContent?.text.toString()
//            Log.i("Buttons", "Delete button pressed")
//            //wordViewModel.remove(Word(word))
//            //adapter.destroy()
//            //adapter.update()
//            adapter.notification()
//        }
//
//        view.findViewById<Button>(R.id.btnEdit)?.setOnClickListener {
//            val txtNoteContent = view?.findViewById<TextView>(R.id.name)
//            val word = txtNoteContent?.text.toString()
//            Log.i("Buttons", "Edit button pressed")
//            //wordViewModel.edit(Word(word))
//        }

        fun bind(text: String?) {
            wordItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): WordViewHolder {
                lateinit var adapter: HomeFragment
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item, parent, false)

                return WordViewHolder(view)
            }
        }
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
