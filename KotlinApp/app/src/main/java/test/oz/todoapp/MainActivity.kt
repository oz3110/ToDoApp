package test.oz.todoapp

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener{
    val m_LoginController : LoginController = LoginController()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button : Button = findViewById(R.id.button)
        button.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        var id = ""
        var pass = ""
        if( m_LoginController.login(id, pass)) {
            val intent: Intent = Intent(this, ToDoActivity::class.java)
            startActivity(intent)
        }
    }
}
