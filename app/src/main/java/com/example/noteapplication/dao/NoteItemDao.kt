package com.example.noteapplication.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.noteapplication.model.NoteItem

@Dao
interface NoteItemDao {

    @Insert
    fun insert(noteItem: NoteItem?)

    @Update
    fun update(noteItem: NoteItem?)

    @Delete
    fun delete(noteItem: NoteItem?)

    @Query("DELETE FROM note_item_table")
    fun deleteAllNotes()

    //@Query("SELECT * FROM note_item_table ORDER BY id DESC")
    //open fun getAllNotes(): LiveData<MutableList<NoteItem?>?>?

    @Query("SELECT * FROM note_item_table WHERE (note_item_is_deleted =0 AND note_item_is_archived =0) ORDER BY id DESC")
    open fun getAllNotes(): LiveData<MutableList<NoteItem?>?>?

    @Query("SELECT * FROM note_item_table WHERE (note_item_is_deleted =0 AND note_item_is_archived =0 AND note_item_id=:noteId) ORDER BY id DESC")
    open fun getAllNoteItems(noteId:Int): LiveData<MutableList<NoteItem?>?>?

    @Query("SELECT * FROM note_item_table WHERE note_item_is_important =1 ORDER BY id DESC")
    open fun getImportantNotes() : LiveData<MutableList<NoteItem?>?>?

    @Query("SELECT * FROM note_item_table WHERE (note_item_is_deleted =1 AND note_item_is_archived =0) ORDER BY id DESC")
    open fun getDeletedNotes() : LiveData<MutableList<NoteItem?>?>?

    @Query("SELECT * FROM note_item_table WHERE (note_item_is_archived =1 AND note_item_is_deleted=0) ORDER BY id DESC")
    open fun getArchivedNotes() : LiveData<MutableList<NoteItem?>?>?
}