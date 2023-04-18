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
package com.example.simple_notepads.ui.noteManagement

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simple_notepads.R
import com.example.simple_notepads.databinding.ActivityNewWordBinding
import com.example.simple_notepads.ui.home.NoteViewModel
import com.example.simple_notepads.ui.home.MovieAdapter

/**
 * Activity for entering a word.
 */

class NewWordActivity : FragmentActivity() {

    lateinit var adapter: NewWordActivity
    private lateinit var noteViewModel: NoteViewModel
    private var _binding: ActivityNewWordBinding? = null
    private lateinit var binding: ActivityNewWordBinding

    fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        noteViewModel =
            ViewModelProvider(this).get(NoteViewModel::class.java)
        binding = ActivityNewWordBinding.inflate(inflater, container, false)

        val editWordView = binding.editWord
        val button = binding.buttonSave

        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editWordView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = editWordView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            }
        }

        val root: View = binding.root
        return root
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}
