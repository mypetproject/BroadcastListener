package com.example.listener

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listener.databinding.NotesListItemBinding

class NotesListAdapter(
    private val notes: List<NoteData>,
) : RecyclerView.Adapter<NotesListAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        NotesListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false).also {
            return NoteViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    override fun getItemCount() = notes.size

    class NoteViewHolder(private val binding: NotesListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(note: NoteData) {
            binding.headerRv.text = note.header
            binding.contentRv.text = note.content
        }
    }
}