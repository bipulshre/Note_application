package com.example.noteapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.model.Note
import com.example.noteapp.repository.NoteRepository
import kotlinx.coroutines.launch
/*
* Any viewmodelscope coroutine launched in this scope is automatically canceled if the
*  ViewModel is cleared. Coroutines are useful here for when you have work that needs
* to be done only if the ViewModel is active. For example, if you are
* computing some data for a layout, you should scope the work to the ViewModel so
* that if the ViewModel is cleared, the work is canceled automatically to avoid consuming
*  resources.
*/
class NoteViewModel(
    app:Application,
    private val noteRepository: NoteRepository
):AndroidViewModel(app) {
    fun addNote(note: Note) = viewModelScope.launch {
        noteRepository.addNote(note)
    }

    fun updateNote(note:Note) =viewModelScope.launch {
        noteRepository.updateNote(note)
    }

    fun deleteNote(note: Note)=viewModelScope.launch {
        noteRepository.deleteNote(note)
    }

    fun getAllNotes()=noteRepository.getAllNotes()

    fun searchNotes(query:String) = noteRepository.searchNote(query)
}