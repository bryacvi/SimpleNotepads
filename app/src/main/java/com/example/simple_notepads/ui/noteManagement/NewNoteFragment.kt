package com.example.simple_notepads.ui.noteManagement

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.simple_notepads.R
import com.example.simple_notepads.examples.word.Word
import com.example.simple_notepads.examples.word.WordViewModel
import com.example.simple_notepads.WordsApplication
import com.example.simple_notepads.databinding.FragmentAboutBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NewNoteFragment : Fragment() {
    private lateinit var viewModel: NewNoteViewModel
    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((activity?.application as WordsApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_newnote, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewNoteViewModel::class.java)

        // We can use Binding instead of looking for views like this
        val editWordView = view?.findViewById<EditText>(R.id.edit_word)
        val button = view?.findViewById<Button>(R.id.button_save)
        val fab = view?.findViewById<FloatingActionButton>(R.id.fab)

        fab?.setOnClickListener {
            findNavController().navigate(R.id.action_newNoteFragment_to_calculatorFragment)
        }

        button?.setOnClickListener {
            Log.i(TAG, "Save button pressed")
            val word = editWordView?.text.toString()

            if (TextUtils.isEmpty(editWordView?.text)) {
                Toast.makeText(context, "You need to add text to save a new note", Toast.LENGTH_SHORT).show()
            } else {
                Log.i(TAG, word)
                wordViewModel.insert(Word(word))
                findNavController().navigateUp()
                Toast.makeText(context, "New Note Saved Successfully", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val TAG = "NewNoteFragment"
    }

}