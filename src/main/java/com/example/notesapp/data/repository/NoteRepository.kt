package com.example.notesapp.data.repository

import com.example.notesapp.data.Folder
import com.example.notesapp.data.FolderDao
import com.example.notesapp.data.Note
import com.example.notesapp.data.NoteDao
import kotlinx.coroutines.flow.Flow

class NoteRepository(
    private val noteDao: NoteDao,
    private val folderDao: FolderDao
) {
    val allNotes: Flow<List<Note>> = noteDao.getAllNotes()
    val allFolders: Flow<List<Folder>> = folderDao.getAllFolders()

    suspend fun insertNote(note: Note) {
        noteDao.insert(note)
    }

    suspend fun updateNote(note: Note) {
        noteDao.update(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDao.delete(note)
    }

    suspend fun insertFolder(folder: Folder) {
        folderDao.insert(folder)
    }
}
