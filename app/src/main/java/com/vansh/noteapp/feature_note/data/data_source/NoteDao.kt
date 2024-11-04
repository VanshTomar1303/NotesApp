package com.vansh.noteapp.feature_note.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vansh.noteapp.feature_note.domain.model.Notes
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("select * from Notes")
    fun getAllNotes(): Flow<List<Notes>>

    @Query("Select * from Notes where id =:id")
    suspend fun getNotesById(id: Int): Notes?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(notes: Notes)

    @Delete
    suspend fun deleteNote(notes: Notes)
}