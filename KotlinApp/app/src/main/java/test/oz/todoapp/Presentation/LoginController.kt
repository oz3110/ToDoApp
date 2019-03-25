package test.oz.todoapp.Presentation

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import test.oz.todoapp.Data.UserModel
import test.oz.todoapp.Domain.UserService

class LoginController( var user : UserModel ){
    var errorString : String = ""
    fun isLogin( userEmail : String, userPass : String ) : Boolean{
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/api/")
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var service = retrofit.create(UserService::class.java)

        service.getUserId( userEmail, userPass ).enqueue(UserModelCallback())

        if( errorString.isEmpty() )return true
        return false
    }

    fun isRegist( userEmail : String, userName : String, userPass : String ) : Boolean{
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/api/")
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var service = retrofit.create(UserService::class.java)

        service.registUserId( userEmail ,userName, userPass).enqueue(UserModelCallback())
        if( errorString.isEmpty() )return true
        return false
    }


    inner class UserModelCallback : retrofit2.Callback<UserModel>{
        override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
            user = response.body()!!
        }

        override fun onFailure(call: Call<UserModel>, t: Throwable) {
            errorString = t.message!!
            Log.v("err",t.message)
        }
    }
}