package com.vansh.noteapp.feature_note.domain.use_case

import com.vansh.noteapp.feature_note.domain.model.Notes
import com.vansh.noteapp.feature_note.domain.repository.NoteRepository
import com.vansh.noteapp.feature_note.domain.util.NoteOrder
import com.vansh.noteapp.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// for arrange notes

class GetNotesUseCase(
    private val repository: NoteRepository
) {
    // has to be one public fun
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Notes>> {
        return repository.getAllNotes().map { notes ->
            when(noteOrder.orderType){
                is OrderType.Ascending -> {
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date ->  notes.sortedBy { it.timestamp }
                        is NoteOrder.Colors -> notes.sortedBy { it.colors }
                    }
                }
                is OrderType.Descending -> {
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date ->  notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Colors -> notes.sortedByDescending { it.colors }
                    }
                }
            }
        }
    }
}