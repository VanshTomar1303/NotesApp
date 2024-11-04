package com.vansh.noteapp.feature_note.domain.use_case

import com.vansh.noteapp.feature_note.domain.model.InvalidNoteException
import com.vansh.noteapp.feature_note.domain.model.Notes
import com.vansh.noteapp.feature_note.domain.repository.NoteRepository

class AddNoteUseCase(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Notes){
        if (note.title.isBlank()){
            throw InvalidNoteException("The title can't be empty.")
        }
        if (note.content.isBlank()){
            throw InvalidNoteException("The content can't be empty.")
        }
        repository.insertNotes(note)
    }
}