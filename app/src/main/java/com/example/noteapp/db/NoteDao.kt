package com.example.noteapp.db

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.noteapp.model.Note


//DAO= Data access object:
/*the Data Access Object is basically an object or an interface
 that provides access to an underlying database or any other persistence storage.*/
@Dao

//interface::the members will have no definition of their own.
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //Suspend function is a function that could be started, paused, and resume
    //they are only allowed to be called from a coroutine or another suspend function
    //co-routine::
    suspend fun addNote(note: Note)

    @Update
    suspend fun updateNote(note :Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query(value = "SELECT * FROM NOTES ORDER BY id DESC")
    fun  getAllNotes(): LiveData<List<Note>>

    @Query(value = "SELECT * FROM NOTES WHERE noteTitle LIKE :query OR noteBody LIKE :query")
    fun  searchNote(query: String?):LiveData<List<Note>>

}