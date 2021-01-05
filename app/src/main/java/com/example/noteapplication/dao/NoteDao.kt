package com.example.noteapplication.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.noteapplication.model.Note

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("DELETE FROM note_table")
    fun deleteAllNotes()

    @Query("SELECT * FROM note_table ORDER BY id DESC")
    open fun getAllNotes(): LiveData<MutableList<Note?>?>?

}