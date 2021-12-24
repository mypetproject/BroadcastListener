package com.example.listener

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotesListFragmentViewModel : ViewModel() {

    private val _notes: MutableLiveData<List<NoteData>> = MutableLiveData(listOf())
    val notes: LiveData<List<NoteData>>
        get() = _notes

    fun addDataToList(header: String, content: String) {

        _notes.value = (_notes.value as List<NoteData>).toMutableList().also {
            it.add(NoteData(header, content))
        }
    }
}