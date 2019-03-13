package test.oz.todoapp.Activity.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import test.oz.todoapp.Activity.ToDoActivity
import test.oz.todoapp.R

class LoadFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_load, container,false)//super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if( cacheLogin() ){
            startActivity( Intent(getActivity(), ToDoActivity::class.java))
            return
        }
        val flagmentTransaction = fragmentManager?.beginTransaction()
        flagmentTransaction?.addToBackStack(null)
        flagmentTransaction?.replace(R.id.container, StartFragment())
        flagmentTransaction?.commit()
    }

    fun cacheLogin() : Boolean{
        return false
    }
}