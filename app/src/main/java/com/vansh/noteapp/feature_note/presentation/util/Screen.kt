package com.vansh.noteapp.feature_note.presentation.util

import android.os.Parcelable
import com.vansh.noteapp.feature_note.presentation.util.Screens.AddEditNotesScreen
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
interface Screens {
    @Serializable
    object NotesScreen : Screens

    @Serializable
    @Parcelize
    data class AddEditNotes(val noteId: Int? = -1, val color: Int = -1) : Screens, Parcelable

    @Serializable
    data class AddEditNotesScreen(val addEditNotes: AddEditNotes) : Screens

    // Route for AddEditNotesScreen
    companion object {
        fun AddEditNotesScreen.toRoute(): String {
            return "addEditNotes/${addEditNotes.noteId}/${addEditNotes.color}"
        }

        fun fromRoute(route: String): AddEditNotesScreen? {
            val segments = route.split("/")
            return if (segments.size == 3) {
                val noteId = segments[1].toInt()
                val color = segments[2].toInt()
                AddEditNotesScreen(AddEditNotes(noteId, color))
            } else {
                null
            }
        }
    }
}


