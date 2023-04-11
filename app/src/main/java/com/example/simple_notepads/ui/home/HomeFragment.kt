package com.example.simple_notepads.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.simple_notepads.databinding.FragmentHomeBinding
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar


class HomeFragment : Fragment() {

    lateinit var adapter: MovieAdapter
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        adapter = MovieAdapter()
        binding.rvItemList.adapter = adapter


        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Sample Text", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvItemList.layoutManager = linearLayoutManager

        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}