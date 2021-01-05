package com.example.noteapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_item_table")
data class NoteItem(
    @PrimaryKey(autoGenerate = true) var id: Int=0,
    @ColumnInfo(name = "note_item_id") val noteId:Int =0,
    @ColumnInfo(name = "note_item_title") val title: String?=null,
    @ColumnInfo(name = "note_item_description") val description: String?=null,
    @ColumnInfo(name = "note_item_created_date") val createdDate:String="",
    @ColumnInfo(name = "note_item_created_time") val createdTime:String="",
    @ColumnInfo(name = "note_item_is_important") val isImportant:Int=0,
    @ColumnInfo(name = "note_item_is_deleted") val isDeleted:Int=0,
    @ColumnInfo(name = "note_item_is_archived") val isArchived:Int =0,
    @ColumnInfo(name = "note_item_color") val color:Int=0,
    //val image:ByteArray?=null,
    @ColumnInfo(name = "note_item_password") val password:String?=null
){
    /*fun displayImage(): Bitmap {
        val bitmap: Bitmap = BitmapFactory.decodeByteArray(image, 0, image!!.size)
        return bitmap
    }*/
}