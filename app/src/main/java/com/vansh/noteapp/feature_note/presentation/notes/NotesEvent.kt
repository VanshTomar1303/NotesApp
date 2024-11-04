package com.vansh.noteapp.feature_note.presentation.notes

import com.vansh.noteapp.feature_note.domain.model.Notes
import com.vansh.noteapp.feature_note.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val notes: Notes): NotesEvent()
    data object RestoreNotes: NotesEvent()
    data object ToggleOrderSection: NotesEvent()
}