package com.vansh.noteapp.feature_note.presentation.notes

import com.vansh.noteapp.feature_note.domain.model.Notes
import com.vansh.noteapp.feature_note.domain.util.NoteOrder
import com.vansh.noteapp.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Notes> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)