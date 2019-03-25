package test.oz.todoapp.Activity.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import test.oz.todoapp.Activity.ToDoActivity
import test.oz.todoapp.R

class LoadFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_load, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if( cacheLogin() ){
            startActivity( Intent(getActivity(), ToDoActivity::class.java))
            return
        }
        Navigation.findNavController(view).navigate(R.id.startFragment)
    }

    fun cacheLogin() : Boolean{
        return false
    }
}