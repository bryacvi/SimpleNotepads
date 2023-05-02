package com.example.simple_notepads.ui.noteManagement

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.simple_notepads.R
import com.example.simple_notepads.ui.home.MovieAdapter

class NewNoteFragment : Fragment() {

    lateinit var adapter: WordListAdapter
    private lateinit var viewModel: NewNoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_newnote, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewNoteViewModel::class.java)
        adapter = WordListAdapter()
        val editWordView = view?.findViewById<EditText>(R.id.edit_word)
        val button = view?.findViewById<Button>(R.id.button_save)

        button?.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editWordView?.text)) {
                activity?.setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = editWordView?.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                activity?.setResult(Activity.RESULT_OK, replyIntent)
            }
            //App crashes after pressing save
            //activity?.finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }

}