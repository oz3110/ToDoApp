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
import test.oz.todoapp.Presentation.LoginController
import test.oz.todoapp.R

class UserRegistFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_regist, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val parentView : View? = getView()

        getView()?.findViewById<Button>(R.id.registOK)?.setOnClickListener({
            val userName : String = parentView?.findViewById<EditText>(R.id.registName).toString()
            val userPass : String = parentView?.findViewById<EditText>(R.id.registPassword).toString()
            val userEmail : String = parentView?.findViewById<EditText>(R.id.registEmail).toString()
            var user : UserModel = UserModel()
            // Dialogでもだす？
            if( LoginController(user).isRegist( userEmail, userName, userPass ) ){
                AlertDialog.Builder(parentView?.context)
                    .setTitle("登録されました")
                    .setPositiveButton("ok"){
                        dialog,witch->
                    }.show()
            }
            else{
                AlertDialog.Builder(parentView?.context)
                    .setTitle("登録に失敗しました")
                    .setPositiveButton("ok"){
                            dialog,witch->
                    }.show()
            }
        })
    }
}