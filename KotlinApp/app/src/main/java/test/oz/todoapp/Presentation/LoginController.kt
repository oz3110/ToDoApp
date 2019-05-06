package test.oz.todoapp.Presentation

import android.util.Log
import android.view.View
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import test.oz.todoapp.Data.UserModel
import test.oz.todoapp.Domain.UserLoginService
import test.oz.todoapp.Domain.UserRegistService
import test.oz.todoapp.Domain.UserService
import test.oz.todoapp.Utility.ResponseMediator

class LoginController( var user : UserModel, var fragment : ResponseMediator){
    var errorString : String = ""
    fun login( userEmail : String, userPass : String ) {
        UserLoginService().login(userEmail,userPass).subscribe({
          // Todo:処理を書く
        })
    }

    fun regist( userEmail : String, userName : String, userPass : String ) {
        UserRegistService().regist(userEmail,userName,userPass).subscribe({

        })
    }

    fun getMessage() : String {
        return errorString
    }

    inner class UserModelCallback : retrofit2.Callback<UserModel>{
        override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
            if( response.code() == 200 || response.code() == 201 ) {
                user = response.body()!!
            }
            fragment.onResponse( response.message(), response.code() )
        }

        override fun onFailure(call: Call<UserModel>, t: Throwable) {
            fragment.onResponse( t.message!!, 500 )
            errorString = t.message!!
            Log.v("err",t.message)
        }
    }
}