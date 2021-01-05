package com.example.noteapplication.repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.noteapplication.dao.NoteItemDao
import com.example.noteapplication.database.NoteItemDatabase
import com.example.noteapplication.model.NoteItem


class NoteItemRepository(application: Application?) {
    private var noteItemDao: NoteItemDao? = null
    private var allNotes: LiveData<MutableList<NoteItem?>?>? = null
    private var allArchivedNotes: LiveData<MutableList<NoteItem?>?>? = null
    private var allDeletedNotes: LiveData<MutableList<NoteItem?>?>? = null

    init {
        val database: NoteItemDatabase? = NoteItemDatabase.getInstance(application!!)
        noteItemDao = database!!.noteItemDao()
        allNotes = noteItemDao!!.getAllNotes()
        allArchivedNotes = noteItemDao!!.getArchivedNotes()
        allDeletedNotes = noteItemDao!!.getDeletedNotes()
    }


    fun insert(noteItem: NoteItem?) {
        InsertNoteItemAsyncTask(noteItemDao).execute(noteItem)
    }


    fun update(noteItem: NoteItem?) {
        UpdateNoteItemAsyncTask(noteItemDao).execute(noteItem)
    }

    fun delete(noteItem: NoteItem?) {
        DeleteNoteItemAsyncTask(noteItemDao).execute(noteItem)
    }

    fun deleteAllNotes() {
        DeleteAllNoteItemAsyncTask(noteItemDao).execute()
    }

    fun getAllNotes(): LiveData<MutableList<NoteItem?>?>? {
        return allNotes
    }

    fun getAllArchivedNotes(): LiveData<MutableList<NoteItem?>?>? {
        return allArchivedNotes
    }

    fun getAllDeletedNotes(): LiveData<MutableList<NoteItem?>?>? {
        return allDeletedNotes
    }

    private class InsertNoteItemAsyncTask(private val noteItemDao: NoteItemDao?) :
        AsyncTask<NoteItem, Void, Void>() {
        override fun doInBackground(vararg params: NoteItem?): Void? {
            noteItemDao!!.insert(params[0])
            return null
        }

    }

    private class UpdateNoteItemAsyncTask(private val noteItemDao: NoteItemDao?) :
        AsyncTask<NoteItem, Void, Void>() {
        override fun doInBackground(vararg params: NoteItem?): Void? {
            noteItemDao!!.update(params[0])
            return null
        }

    }

    private class DeleteNoteItemAsyncTask(private val noteItemDao: NoteItemDao?) :
        AsyncTask<NoteItem, Void, Void>() {
        override fun doInBackground(vararg params: NoteItem?): Void? {
            noteItemDao!!.delete(params[0])
            return null
        }

    }

    private class DeleteAllNoteItemAsyncTask(private val noteItemDao: NoteItemDao?) :
        AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            noteItemDao!!.deleteAllNotes()
            return null
        }


    }


}

