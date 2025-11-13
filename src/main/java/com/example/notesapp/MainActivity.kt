package com.example.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.notesapp.data.NoteDatabase
import com.example.notesapp.data.repository.NoteRepository
import com.example.notesapp.ui.NavGraph
import com.example.notesapp.ui.theme.NotesAppTheme
import com.example.notesapp.viewModel.FolderListViewModel
import com.example.notesapp.viewModel.NoteEditorViewModel
import com.example.notesapp.viewModel.NoteListViewModel
import com.example.notesapp.viewModel.ViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = NoteDatabase.getDatabase(this)
        val repository = NoteRepository(database.noteDao(), database.folderDao())
        val factory = ViewModelFactory(repository)

        val noteListViewModel: NoteListViewModel by viewModels { factory }
        val noteEditorViewModel: NoteEditorViewModel by viewModels { factory }
        val folderListViewModel: FolderListViewModel by viewModels { factory }

        setContent {
            NotesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavGraph(noteListViewModel, noteEditorViewModel, folderListViewModel)
                }
            }
        }
    }
}
