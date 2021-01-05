package com.example.noteapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey(autoGenerate = true) var id: Int =0,
    @ColumnInfo(name = "note_title") val title:String?=null,
    @ColumnInfo(name = "note_color") val color:Int?=null
)