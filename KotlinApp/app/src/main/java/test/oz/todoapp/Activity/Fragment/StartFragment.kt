package test.oz.todoapp.Activity.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import test.oz.todoapp.Activity.ToDoActivity
import test.oz.todoapp.R

class StartFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_start, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getView()?.findViewById<Button>(R.id.loginButton)?.setOnClickListener({
            Navigation.findNavController(view).navigate(R.id.userLoginFragment)
        })
        getView()?.findViewById<Button>(R.id.registButton)?.setOnClickListener({
            Navigation.findNavController(view).navigate(R.id.userRegistFragment)
        })
    }
}