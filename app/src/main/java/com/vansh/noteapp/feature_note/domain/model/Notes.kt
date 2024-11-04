package com.vansh.noteapp.feature_note.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Notes(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String,
    val content: String,
    val timestamp : Long,
    val colors: Int
){
    companion object{
        val notesColor = listOf(Color.Yellow,Color.Red,Color.Blue,Color.Magenta, Color.Green)
    }
}

class InvalidNoteException(message: String): Exception(message)
