package com.example.notesapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.notesapp.ui.screen.NoteEditorScreen
import com.example.notesapp.ui.screen.NoteListScreen
import com.example.notesapp.viewModel.FolderListViewModel
import com.example.notesapp.viewModel.NoteEditorViewModel
import com.example.notesapp.viewModel.NoteListViewModel

@Composable
fun NavGraph(
    noteListViewModel: NoteListViewModel,
    noteEditorViewModel: NoteEditorViewModel,
    folderListViewModel: FolderListViewModel
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "note_list") {
        composable("note_list") {
            NoteListScreen(
                viewModel = noteListViewModel,
                onNoteClick = { noteId ->
                    navController.navigate("note_editor/$noteId")
                },
                onNewNoteClick = {
                    navController.navigate("note_editor")
                }
            )
        }
        composable(
            route = "note_editor/{noteId}",
            arguments = listOf(navArgument("noteId") { type = NavType.IntType })
        ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getInt("noteId")
            val note = if (noteId != null && noteId != 0) {
                noteListViewModel.notes.collectAsState().value.find { it.id == noteId }
            } else {
                null
            }
            NoteEditorScreen(
                note = note,
                onSave = { newNote ->
                    noteEditorViewModel.saveNote(newNote)
                    navController.popBackStack()
                }
            )
        }
    }
}
