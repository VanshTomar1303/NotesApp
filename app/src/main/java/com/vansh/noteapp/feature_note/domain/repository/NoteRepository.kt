package com.vansh.noteapp.feature_note.domain.repository

import com.vansh.noteapp.feature_note.domain.model.Notes
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getAllNotes(): Flow<List<Notes>>

    suspend fun getNotesById(id: Int): Notes?

    suspend fun insertNotes(notes: Notes)

    suspend fun deleteNotes(notes: Notes)
}