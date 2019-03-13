package test.oz.todoapp.Activity.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import test.oz.todoapp.Activity.ToDoActivity
import test.oz.todoapp.R

class UserRegistFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val parentView : View? = getView()

        parentView?.findViewById<Button>(R.id.loginButton)?.setOnClickListener({
            val userId : String = parentView?.findViewById<EditText>(R.id.userID).toString()
            val userPass : String = parentView?.findViewById<EditText>(R.id.userPass).toString()

            // Dialogでもだす？
        })
    }
}