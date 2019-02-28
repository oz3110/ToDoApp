package test.oz.todoapp

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button : Button = findViewById(R.id.button)
        val text : TextView = findViewById(R.id.textView)
        val dialog = AlertDialog.Builder(this)
        button.setOnClickListener({
            dialog.setTitle("Input ToDo")
            dialog.setView(text)
            dialog.setPositiveButton("OK", DialogInterface.OnClickListener({
                _, _ ->
                val userText = text.getText().toString()
                Toast.makeText(this, "$userText と入力しました", Toast.LENGTH_SHORT).show()
            }))
            dialog.setNegativeButton("キャンセル", null)
            dialog.show()
        })
    }
}
