package test.oz.todoapp.Presentation

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import test.oz.todoapp.Data.UserModel
import test.oz.todoapp.Domain.UserService

class LoginController{

    fun isLogin( userId : String, userPass : String ) : Boolean{
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/api/")
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        var service = retrofit.create(UserService::class.java)

        service.getUserId( 1 ).enqueue(UserModelCallback())

        return true
    }


    inner class UserModelCallback : retrofit2.Callback<UserModel>{
        override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
            if( response?.body()?.id != null ){
                Log.v("userName",response.body()!!.name)
                Log.v("userEmail",response.body()!!.email)
            }
        }

        override fun onFailure(call: Call<UserModel>, t: Throwable) {
            Log.v("err",t.message)
        }
    }
}