package com.example.simple_notepads.ui.home

import android.os.Bundle
import android.util.Log
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
import com.example.simple_notepads.WordsApplication
import com.example.simple_notepads.databinding.FragmentHomeBinding
import com.example.simple_notepads.examples.word.WordListAdapter
import com.example.simple_notepads.examples.word.WordViewModel
import com.example.simple_notepads.ui.noteManagement.WordViewModelFactory


class HomeFragment : Fragment() {

    lateinit var adapter: WordListAdapter
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private lateinit var binding: FragmentHomeBinding
    private var deleteValue = false

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
        adapter = WordListAdapter(
            WordListAdapter.OnClickListener { word ->
                Log.i(TAG, "Clicked on ${word.word}")}
        )
        binding.rvItemList.adapter = adapter

        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvItemList.layoutManager = linearLayoutManager

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_nav_home_to_NewNoteFragment)
        }

        if (deleteValue) {
            wordViewModel.wipeDB()
        }

        wordViewModel.allWords.observe(viewLifecycleOwner) { words ->
        //Update the cached copy of the words in the adapter.
            words.let { adapter.submitList(it) }
        }

            return binding.root
        }

    fun notification () {
        deleteValue = true
    }

        companion object {
            private const val TAG = "HomeFragment"
        }


        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }

    }