package test.oz.todoapp.Activity

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import test.oz.todoapp.R

class ToDoActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        val button : Button = findViewById(R.id.ToDo)
        button.setOnClickListener(this)
    }
    override fun onClick(p0: View?){
        AlertDialog.Builder(this).apply {
            setTitle("AddToDo")
            setPositiveButton(R.string.dialog_ok, DialogInterface.OnClickListener({
                    _, _ -> Toast.makeText(context, "Dialog OK", Toast.LENGTH_LONG).show()
            }))
            setNegativeButton(R.string.dialog_cancel, null)
            show()
        }
    }
}