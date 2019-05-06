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
import androidx.navigation.Navigation
import test.oz.todoapp.Activity.ToDoActivity
import test.oz.todoapp.Data.UserModel
import test.oz.todoapp.Domain.UserRegistService
import test.oz.todoapp.Presentation.LoginController
import test.oz.todoapp.R
import test.oz.todoapp.Utility.ResponseMediator

class UserRegistFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val parent : View = inflater.inflate(R.layout.fragment_regist, container,false)
        parent.findViewById<Button>(R.id.registOK)?.setOnClickListener({
            val userName : String = parent.findViewById<EditText>(R.id.registName).text.toString()
            val userPass : String = parent.findViewById<EditText>(R.id.registPassword).text.toString()
            val userEmail : String = parent.findViewById<EditText>(R.id.registEmail).text.toString()
            UserRegistService().regist( userEmail, userName, userPass ).subscribe({
                if( it.isSuccessful ){
                    AlertDialog.Builder(view?.context)
                        .setTitle("登録されました")
                        .setPositiveButton("ok", null)
                        .show()

                    Navigation.findNavController(view!!).navigate(R.id.startFragment)
                }else{
                    AlertDialog.Builder(view?.context)
                        .setTitle("登録に失敗しました")
                        .setPositiveButton("ok", null)
                        .show()
                }
            })

        })
        return parent
    }
}