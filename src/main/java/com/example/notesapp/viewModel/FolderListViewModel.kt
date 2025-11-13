package com.example.notesapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.data.Folder
import com.example.notesapp.data.repository.NoteRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FolderListViewModel(private val repository: NoteRepository) : ViewModel() {

    val folders: StateFlow<List<Folder>> = repository.allFolders
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addFolder(folderName: String) {
        viewModelScope.launch {
            repository.insertFolder(Folder(name = folderName))
        }
    }
}
