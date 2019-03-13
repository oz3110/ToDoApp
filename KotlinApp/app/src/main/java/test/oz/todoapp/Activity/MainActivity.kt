package test.oz.todoapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Response
import test.oz.todoapp.Activity.Fragment.LoadFragment
import test.oz.todoapp.Data.UserModel
import test.oz.todoapp.R

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
