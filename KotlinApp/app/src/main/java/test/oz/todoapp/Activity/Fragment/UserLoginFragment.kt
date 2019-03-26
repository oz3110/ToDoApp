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
import test.oz.todoapp.Data.UserModel
import test.oz.todoapp.Presentation.LoginController
import test.oz.todoapp.R

class UserLoginFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val parent : View = inflater.inflate(R.layout.fragment_login, container,false)

        parent.findViewById<Button>(R.id.loginButton)?.setOnClickListener({
            val userId : String = parent.findViewById<EditText>(R.id.userID).text.toString()
            val userPass : String = parent.findViewById<EditText>(R.id.userPass).text.toString()

            var user : UserModel = UserModel()
            if( LoginController(user).isLogin( userId, userPass ) ){

            }
        })
        return parent
    }
}