package com.example.noteapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteapp.model.Note

/*
A abstract class is a class which cannot be instantiated, meaning you cannot create new
instances of an abstract class. The purpose of an abstract class is to function as a base for subclasses
*/

//appdatabase defines the database configuration and serves as the app's main access point
// to the persisted data
//an entities array that lists all of the data entities associated with the database.
@Database(entities = [Note::class],version = 1)
abstract class NoteDatabase :RoomDatabase(){

    abstract fun getNoteDao(): NoteDao

    companion object{

        @Volatile
        private var instance: NoteDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance?: synchronized(LOCK){
            instance?:
            createDatabase(context).also {
                instance=it

            }
        }
//to create an instance of the database:
        private fun createDatabase(context: Context) =Room.databaseBuilder(
            context.applicationContext,
            NoteDatabase::class.java,
            "note_db"


            ).build()
    }
}