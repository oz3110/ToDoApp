package test.oz.todoapp.Activity.Fragment

import android.app.AlertDialog
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
import test.oz.todoapp.Domain.UserLoginService
import test.oz.todoapp.Presentation.LoginController
import test.oz.todoapp.R
import test.oz.todoapp.Utility.ResponseMediator

class UserLoginFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val parent : View = inflater.inflate(R.layout.fragment_login, container,false)

        parent.findViewById<Button>(R.id.loginButton)?.setOnClickListener({
            val userEmail : String = parent.findViewById<EditText>(R.id.userID).text.toString()
            val userPass : String = parent.findViewById<EditText>(R.id.userPass).text.toString()

            val user = UserLoginService().login( userEmail, userPass )
            user.subscribe(){
                if( it.code() == 200 || it.code() == 201 ){
                    AlertDialog.Builder(view?.context)
                        .setTitle("認証成功しました")
                        .setPositiveButton("ok", null)
                        .show()
                }
                else{
                    AlertDialog.Builder(view?.context)
                        .setTitle("認証失敗しました")
                        .setPositiveButton("ok", null)
                        .show()
                }
            }
            //LoginController(user, this).login( userId, userPass )
        })
        return parent
    }
}