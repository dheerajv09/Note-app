package com.example.noteapplication.database

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.noteapplication.dao.NoteDao
import com.example.noteapplication.dao.NoteItemDao
import com.example.noteapplication.model.Note
import com.example.noteapplication.model.NoteItem


@Database(entities = [NoteItem::class, Note::class], version = 1)
abstract class NoteItemDatabase : RoomDatabase() {

    abstract fun noteItemDao(): NoteItemDao?
    abstract fun noteDao(): NoteDao?

    companion object{
        // Singleton prevents multiple instances of database opening at the
        // same time.
        private var instance: NoteItemDatabase? = null

        @Synchronized
        fun getInstance(context: Context): NoteItemDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteItemDatabase::class.java,
                    "note_database"
                ).fallbackToDestructiveMigration().addCallback(roomCallback).build()
            }
            return instance
        }

        private val roomCallback: Callback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateDbAsyncTask(instance).execute()
            }
        }

    }


    private class PopulateDbAsyncTask(noteItemDatabase: NoteItemDatabase?): AsyncTask<Void, Void, Void>(){
        //private val noteItemDao: NoteItemDao = noteItemDatabase!!.noteItemDao()!!
        private val noteDao: NoteDao = noteItemDatabase!!.noteDao()!!


        override fun doInBackground(vararg params: Void?): Void? {
            noteDao.insert(Note(title = "Home"))
            noteDao.insert(Note(title = "Work"))
            noteDao.insert(Note(title = "Vacation"))
            //add extra line to show all above three card
            //include it only if plus card is added
            noteDao.insert(Note(title = "alpha"))
            return null
        }

    }


}