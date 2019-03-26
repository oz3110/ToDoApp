package test.oz.todoapp.Domain

import retrofit2.Call
import retrofit2.http.*
import test.oz.todoapp.Data.UserModel

interface UserService {

    @GET( "/users/email/{email}/password/{password}" )
    fun getUserId(
        @Query( "email" )email : String,
        @Query( "password" )password : String
    ) : Call<UserModel>

    @POST( "/users")
    fun registUserId(
        @Field( "email" ) email : String,
        @Field( "name" ) name : String,
        @Field( "password" ) password : String
    ): Call<UserModel>


}