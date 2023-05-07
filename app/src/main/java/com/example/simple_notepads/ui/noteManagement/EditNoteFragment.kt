package com.example.simple_notepads.ui.noteManagement

import android.app.AlertDialog
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

class EditNoteFragment : Fragment() {
    private lateinit var viewModel: EditNoteViewModel
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
        viewModel = ViewModelProvider(this).get(EditNoteViewModel::class.java)

        // We can use Binding instead of looking for views like this
        val editWordView = view?.findViewById<EditText>(R.id.edit_word)
        val button = view?.findViewById<Button>(R.id.button_save)
        val word = requireArguments().getString("word").toString()
        editWordView?.setText(word)

        button?.setOnClickListener {
            Log.i(TAG, "Save button pressed")
            val edit = editWordView?.text.toString()

            if (TextUtils.isEmpty(editWordView?.text) || TextUtils.equals(editWordView?.text, word)) {
                Toast.makeText(context, "You need to edit the note to save", Toast.LENGTH_SHORT).show()
            } else {
                val builder = AlertDialog.Builder(context)
                builder.setMessage("Save edited Note?")
                    .setCancelable(false)
                    .setPositiveButton("Yes") { dialog, id ->
                        // Edit selected note in database
                        wordViewModel.edit(Word(word), Word(edit))
                        findNavController().navigateUp()
                        Toast.makeText(context, "Note Saved Successfully", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("No") { dialog, id ->
                        // Dismiss the dialog
                        dialog.dismiss()
                    }
                val alert = builder.create()
                alert.show()
            }
        }
    }

    companion object {
        private const val TAG = "NewNoteFragment"
    }

}