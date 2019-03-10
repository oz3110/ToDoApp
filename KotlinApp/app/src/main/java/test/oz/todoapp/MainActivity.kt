package test.oz.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val flagmentTransaction = supportFragmentManager.beginTransaction()
            flagmentTransaction.replace(R.id.container, LoadFragment())
            flagmentTransaction.commit()
        }
    }
}
