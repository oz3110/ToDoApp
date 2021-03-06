package test.oz.todoapp.Domain

import retrofit2.Call
import retrofit2.http.*
import test.oz.todoapp.Data.UserModel

interface UserService {

    @GET( "/api/users/email/{email}/password/{password}" )
    fun getUserId(
        @Path( "email" )email : String,
        @Path( "password" )password : String
    ) : Call<UserModel>

    @FormUrlEncoded
    @POST( "/api/users")
    fun registUserId(
        @Field( "email" ) email : String,
        @Field( "name" ) name : String,
        @Field( "password" ) password : String
    ): Call<UserModel>


}