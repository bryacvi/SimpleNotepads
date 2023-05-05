package com.example.simple_notepads.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simple_notepads.R
import com.example.simple_notepads.databinding.FragmentHomeBinding
import com.example.simple_notepads.examples.word.WordListAdapter
import com.example.simple_notepads.examples.word.WordViewModel
import com.example.simple_notepads.WordsApplication
import com.example.simple_notepads.ui.noteManagement.WordViewModelFactory


class HomeFragment : Fragment() {

    lateinit var adapter: WordListAdapter
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private lateinit var binding: FragmentHomeBinding

    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((activity?.application as WordsApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        adapter = WordListAdapter()
        binding.rvItemList.adapter = adapter

        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvItemList.layoutManager = linearLayoutManager

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_NewNoteFragment)
        }

        /*view?.findViewById<Button>(R.id.btnDelete)?.setOnClickListener {
            val txtNoteContent = view?.findViewById<TextView>(R.id.name)
            //Log.i(TAG, "Delete button pressed")
            val word = txtNoteContent?.text.toString()
            wordViewModel.remove(Word(word))
        }

        view?.findViewById<Button>(R.id.btnEdit)?.setOnClickListener {
            Toast.makeText(context, "You clicked me.", Toast.LENGTH_SHORT).show()
            //wordViewModel.edit(Word(word))
        }*/

        //crash from the start
        wordViewModel.allWords.observe(viewLifecycleOwner) { words ->
//          Update the cached copy of the words in the adapter.
            words.let { adapter.submitList(it) }
        }

            return binding.root

        }

        companion object {
            private const val TAG = "HomeFragment"
        }


        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }

    }