package com.vansh.noteapp.feature_note.domain.use_case

import com.vansh.noteapp.feature_note.domain.model.Notes
import com.vansh.noteapp.feature_note.domain.repository.NoteRepository

class DeleteNotesUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(notes: Notes){
        repository.deleteNotes(notes = notes)
    }
}