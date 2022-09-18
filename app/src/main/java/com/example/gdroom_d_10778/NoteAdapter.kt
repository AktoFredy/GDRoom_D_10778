package com.example.gdroom_d_10778

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gdroom_d_10778.room.Note
import kotlinx.android.synthetic.main.activity_note_adapter.view.*

class NoteAdapter (private val notes: ArrayList<Note>, private val listener: OnAdapterListener) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder{
        return NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_note_adapter, parent, false))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int){
        val note = notes[position]
        holder.view.text_title.text = note.title
        holder.view.text_title.setOnClickListener{
            listener.onClick(note)
        }
        holder.view.icon_edit.setOnClickListener{
            listener.onUpdate(note)
        }
        holder.view.icon_delete.setOnClickListener{
            listener.onDelete(note)
        }
    }

    override fun getItemCount() = notes.size
    inner class NoteViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Note>){
        notes.clear()
        notes.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener{
        fun onClick(note: Note)
        fun onUpdate(note: Note)
        fun onDelete(note: Note)
    }

}