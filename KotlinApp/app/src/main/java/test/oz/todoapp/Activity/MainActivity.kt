package test.oz.todoapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm
import retrofit2.Call
import retrofit2.Response
import test.oz.todoapp.Activity.Fragment.LoadFragment
import test.oz.todoapp.Data.UserModel
import test.oz.todoapp.R

class MainActivity : AppCompatActivity(){
    var mRealm : Realm? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Realm.init(this)
        mRealm = Realm.getDefaultInstance()
    }
    override fun onDestroy(){
        super.onDestroy()
        mRealm?.close()
    }
}
