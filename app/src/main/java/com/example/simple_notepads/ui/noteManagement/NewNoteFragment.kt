package com.example.simple_notepads.ui.noteManagement

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.simple_notepads.R
import com.example.simple_notepads.examples.word.Word
import com.example.simple_notepads.examples.word.WordViewModel
import com.example.simple_notepads.WordsApplication

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

        button?.setOnClickListener {
            Log.i(TAG, "Save button pressed")

            if (TextUtils.isEmpty(editWordView?.text)) {
                // Add a message to say field is empty, with SnackBar or Toast
            } else {
                val word = editWordView?.text.toString()
                Log.i(TAG, word)
                wordViewModel.insert(Word(word))
                // Use a SnackBar to add success message for saving
                // Navigate back to Home.
                findNavController().navigateUp()
            }
        }
    }

    companion object {
        private const val TAG = "NewNoteFragment"
    }

}