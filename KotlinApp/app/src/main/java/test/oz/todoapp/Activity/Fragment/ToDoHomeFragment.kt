package test.oz.todoapp.Activity.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_todo_home.*
import test.oz.todoapp.R
import test.oz.todoapp.Utility.RecyclerAdapter
import test.oz.todoapp.Utility.RecyclerViewHolder

class ToDoHomeFragment : Fragment(), RecyclerViewHolder.ItemClickListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate( R.layout.fragment_todo_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // DBから取得するToDoList
        //val todoList =
        //todo_recyclerview.adapter = RecyclerAdapter( context, this, todoList )
        //todo_recyclerview.layoutManager = LinearLayoutManager( context, RecyclerView.VERTICAL, false )

    }

    override fun onItemClick(view: View, position: Int) {

    }
}