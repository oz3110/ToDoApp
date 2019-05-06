package test.oz.todoapp.Domain

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import test.oz.todoapp.Data.UserModel

interface IUserRegistRequest {
    @POST( "api/users/")
    fun registUser(
          @Body body: HashMap<String, String>
//        @Query( "email" ) email : String,
//        @Query( "name" ) name : String,
//        @Query( "password" ) password : String
    ): Observable<Response<UserModel>>
}