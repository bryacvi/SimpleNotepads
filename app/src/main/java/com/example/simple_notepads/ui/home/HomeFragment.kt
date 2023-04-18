package com.example.simple_notepads.ui.home

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simple_notepads.BlankFragment
import com.example.simple_notepads.databinding.FragmentBlankBinding
import com.example.simple_notepads.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.content_main.nav_host_fragment_content_main


class HomeFragment : Fragment() {

    private val newWordActivityRequestCode = 1
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


        binding.fab.setOnClickListener {
            fragmentManager.beginTransaction().replace(R.id.container, MyFragment.newInstance(arg1, arg2)).commit();
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