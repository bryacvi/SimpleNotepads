package com.example.notepad_calculator.ui.home

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.notepad_calculator.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.notepad_calculator.R


class HomeFragment : Fragment() {

    lateinit var adapter: MovieAdapter
    private lateinit var homeViewModel: HomeViewModel

    lateinit var recyclerView: RecyclerView
    lateinit var swipeRefresh: SwipeRefreshLayout

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    //private val binding get() = _binding!!
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        //_binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        adapter = MovieAdapter()
        binding.rvItemList.adapter = adapter

        //Toast.makeText(this.context, "Refreshed", Toast.LENGTH_LONG).show() //Notification

        /*recyclerView.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, true)
        linearLayoutManager.stackFromEnd = true

        recyclerView.layoutManager = linearLayoutManager

        swipeRefresh = view.findViewById(R.id.swiperefresh)

        swipeRefresh.setOnRefreshListener {

            Toast.makeText(context, " Adapter size: ${postAdapter.itemCount}", Toast.LENGTH_LONG).show() // works : returns 12
            println("list:${homeViewmodel.postList.value} ") works : prints data

            swipeRefresh.isRefreshing = false
        }

        return view*/



        //val linearLayoutManager: LinearLayoutManager = root.rootView(R.id.linearLayoutManager)
        /*adapter = MovieAdapter()
        rv_item_list.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rv_item_list.adapter = adapter*/
        val root: View = binding.root
        //val textView: TextView = binding.textHome
        //homeViewModel.text.observe(viewLifecycleOwner, Observer {
        //    textView.text = it
        //})
        return root
    }

    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = LayoutInflater
        inflater.inflate(R.menu.buttons, menu)
        return true
    }*/

    /*override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.accessibilityActionShowOnScreen -> {
            adapter.refreshMovies()

            //Toast.makeText(this.baseContext, "Refreshed", Toast.LENGTH_LONG).show())
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}