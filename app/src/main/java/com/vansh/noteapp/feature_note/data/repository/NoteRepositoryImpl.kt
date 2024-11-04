package com.vansh.noteapp.feature_note.data.repository

import com.vansh.noteapp.feature_note.data.data_source.NoteDao
import com.vansh.noteapp.feature_note.domain.model.Notes
import com.vansh.noteapp.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {
    override fun getAllNotes(): Flow<List<Notes>> {
        return dao.getAllNotes()
    }

    override suspend fun getNotesById(id: Int): Notes? {
       return dao.getNotesById(id)
    }

    override suspend fun insertNotes(notes: Notes) {
        dao.insertNotes(notes)
    }

    override suspend fun deleteNotes(notes: Notes){
        dao.deleteNote(notes)
    }

}