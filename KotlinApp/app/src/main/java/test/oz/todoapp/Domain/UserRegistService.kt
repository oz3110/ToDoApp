package test.oz.todoapp.Domain

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import test.oz.todoapp.Data.UserModel
import test.oz.todoapp.Utility.ConstantData

class UserRegistService {
    fun regist( userEmail : String, userName : String, userPassword : String ) : Observable<Response<UserModel>>{
        val retrofit = Retrofit.Builder()
            .baseUrl( "http://10.0.2.2/")
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        val service = retrofit.create(IUserRegistRequest::class.java)
        return service.registUser( hashMapOf("email" to userEmail, "userName" to userName, "userPassword" to userPassword ) )
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
    }
}