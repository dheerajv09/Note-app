package com.example.noteapplication.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.noteapplication.model.NoteItem
import com.example.noteapplication.repository.NoteItemRepository


class NoteItemViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: NoteItemRepository? = null
    private var allNotes: LiveData<MutableList<NoteItem?>?>? = null
    private var allArchivedNotes: LiveData<MutableList<NoteItem?>?>? = null
    private var allDeletedNotes: LiveData<MutableList<NoteItem?>?>? = null

    init {
        repository = NoteItemRepository(application)
        allNotes = repository!!.getAllNotes()
        allArchivedNotes = repository!!.getAllArchivedNotes()
        allDeletedNotes = repository!!.getAllDeletedNotes()
    }

    fun insert(note: NoteItem?) {
        repository!!.insert(note)
    }

    fun update(note: NoteItem?) {
        repository!!.update(note)
    }

    fun delete(note: NoteItem?) {
        repository!!.delete(note)
    }

    fun deleteAllNotes() {
        repository!!.deleteAllNotes()
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

}
