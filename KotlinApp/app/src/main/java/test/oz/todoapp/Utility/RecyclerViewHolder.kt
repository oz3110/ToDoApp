package test.oz.todoapp.Utility

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import test.oz.todoapp.R

class RecyclerViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    interface ItemClickListener{
        fun onItemClick(view : View, position : Int)
    }
    val itemTextView : TextView = view.findViewById(R.id.todo_item)
    val itemShow : TextView = view.findViewById(R.id.todo_show)
}