package com.todo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.todo.R
import com.todo.model.ToDo

class ToDoAdapter(var toDoList: MutableList<ToDo>, var context: Context) :
    RecyclerView.Adapter<ToDoAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var card = itemView.findViewById<CardView>(R.id.card)
        var date = itemView.findViewById<TextView>(R.id.dateRecView)
        var dateTB = itemView.findViewById<TextView>(R.id.dateT)
        var time = itemView.findViewById<TextView>(R.id.timeRecView)
        var timeTB = itemView.findViewById<TextView>(R.id.timeT)
        var checkBox = itemView.findViewById<CheckBox>(R.id.checkBox)
        var description = itemView.findViewById<TextView>(R.id.descRecView)
        var title = itemView.findViewById<TextView>(R.id.titleRecView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_in_rec_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return toDoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            title.text = toDoList[position].title
            description.text = toDoList[position].description
            time.text = toDoList[position].time
            date.text = toDoList[position].date
            checkBox.isChecked = toDoList[position].checkBox


        }
    }
}