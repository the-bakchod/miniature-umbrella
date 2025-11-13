package com.example.notesapp.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.notesapp.data.database.NoteDatabase
import com.example.notesapp.data.model.Note
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NoteRepositoryTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: NoteDatabase
    private lateinit var repository: NoteRepository

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NoteDatabase::class.java
        ).allowMainThreadQueries().build()
        repository = NoteRepository(database.noteDao(), database.folderDao())
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertAndGetNote() = runBlocking {
        val note = Note(title = "Test Note", content = "Test Content", folderId = null)
        repository.insertNote(note)
        val allNotes = repository.allNotes.first()
        assertEquals(allNotes[0].title, "Test Note")
    }
}
