package com.example.simple_notepads.ui.noteManagement

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData
import com.example.simple_notepads.examples.word.Word
import com.example.simple_notepads.examples.word.WordRepository
import com.example.simple_notepads.examples.word.WordViewModel

class NoteViewModel(private val repository: WordRepository) : ViewModel() {

    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()

    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }

    fun delete() = viewModelScope.launch {
        repository.deleteAll()
    }

}

class WordViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}