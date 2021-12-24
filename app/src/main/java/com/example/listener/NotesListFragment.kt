package com.example.listener

import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.listener.databinding.FragmentNotesListBinding

class NotesListFragment : Fragment() {

    private val model: NotesListFragmentViewModel by viewModels()

    private val receiver by lazy { NoteReceiver(model) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentNotesListBinding.inflate(inflater, container, false).also {

            model.notes.observe(this, { notes ->
                it.notesRecyclerview.adapter =
                    NotesListAdapter(notes)
            })

            activity?.registerReceiver(receiver, IntentFilter().apply { addAction(ACTION) })
        }.root

    override fun onDestroy() {
        super.onDestroy()
        activity?.unregisterReceiver(receiver)
    }

    companion object {
        private const val ACTION = "com.example.bschomework.action_saving"
    }
}