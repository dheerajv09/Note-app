package com.example.noteapplication.repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.noteapplication.dao.NoteDao
import com.example.noteapplication.database.NoteItemDatabase
import com.example.noteapplication.model.Note


class NoteRepository(application: Application?) {

    private var noteDao: NoteDao?=null
    private var allNotes: LiveData<MutableList<Note?>?>? = null

    init {
        val database: NoteItemDatabase? = NoteItemDatabase.getInstance(application!!)
        noteDao = database!!.noteDao()
        allNotes = noteDao!!.getAllNotes()
    }

    fun insert(note: Note?) {
        InsertNoteAsyncTask(noteDao).execute(note)
    }


    fun update(note: Note?) {
        UpdateNoteAsyncTask(noteDao).execute(note)
    }

    fun delete(note: Note?) {
        DeleteNoteAsyncTask(noteDao).execute(note)
    }

    fun deleteAllNotes() {
        DeleteAllNoteAsyncTask(noteDao).execute()
    }

    fun getAllNotes(): LiveData<MutableList<Note?>?>? {
        return allNotes
    }

    private class InsertNoteAsyncTask(private val noteDao: NoteDao?) :
        AsyncTask<Note, Void, Void>() {
        override fun doInBackground(vararg params: Note?): Void? {
            noteDao!!.insert(params[0]!!)
            return null
        }

    }

    private class UpdateNoteAsyncTask(private val noteDao: NoteDao?) :
        AsyncTask<Note, Void, Void>() {
        override fun doInBackground(vararg params: Note?): Void? {
            noteDao!!.update(params[0]!!)
            return null
        }

    }

    private class DeleteNoteAsyncTask(private val noteDao: NoteDao?) :
        AsyncTask<Note, Void, Void>() {
        override fun doInBackground(vararg params: Note?): Void? {
            noteDao!!.delete(params[0]!!)
            return null
        }

    }

    private class DeleteAllNoteAsyncTask(private val noteDao: NoteDao?) :
        AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            noteDao!!.deleteAllNotes()
            return null
        }


    }
}