package com.example.noteapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

//data class::classes whose main purpose is to hold data
//In such classes, some standard functionality and some utility
// functions are often mechanically derivable from the data

@Entity(tableName = "notes")
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val noteTitle: String,
    val noteBody:String): Parcelable

