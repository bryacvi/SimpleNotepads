package com.example.simple_notepads.ui.about

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.simple_notepads.R
import com.example.simple_notepads.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private lateinit var viewModel: AboutViewModel
    private var _binding: FragmentAboutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AboutViewModel::class.java)
        val webView = view?.findViewById<WebView>(R.id.webView)
        val video = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/" +
                "c18WZZa4KIA?si=PGU3Ppp-3k8YW8oN\" title=\"YouTube video player\" frameborder=" +
                "\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; " +
                "gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when" +
                "-cross-origin\"></iframe>"
        webView?.loadData(video,"text/html", "utf-8")
        webView?.settings?.javaScriptEnabled = true
        webView?.webChromeClient
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}