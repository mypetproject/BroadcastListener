package com.example.listener

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class NoteReceiver(private val model: NotesListFragmentViewModel) : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {

        model.addDataToList(
            p1?.getStringExtra(NOTE_HEADER) ?: "",
            p1?.getStringExtra(NOTE_CONTENT) ?: ""
        )
    }

    companion object {
        private const val NOTE_HEADER = "note_header"
        private const val NOTE_CONTENT = "note_content"
    }
}