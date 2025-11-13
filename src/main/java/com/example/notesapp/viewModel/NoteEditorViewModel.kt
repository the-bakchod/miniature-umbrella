package com.example.notesapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.data.Note
import com.example.notesapp.data.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteEditorViewModel(
    private val repository: NoteRepository
) : ViewModel() {

    fun saveNote(note: Note) {
        viewModelScope.launch {
            if (note.id == 0) {
                repository.insertNote(note)
            } else {
                repository.updateNote(note)
            }
        }
    }
}
