package test.oz.todoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class UserLoginFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val parentView : View? = getView()

        parentView?.findViewById<Button>(R.id.loginButton)?.setOnClickListener({
            val userId : String = parentView?.findViewById<EditText>(R.id.userID).toString()
            val userPass : String = parentView?.findViewById<EditText>(R.id.userPass).toString()

            if( isLogin( userId , userPass) ){
                // ToDoアクティビティへ遷移
            }
        })
    }

    fun isLogin( userID : String, userPass : String ) : Boolean
    {
        return true
    }
}