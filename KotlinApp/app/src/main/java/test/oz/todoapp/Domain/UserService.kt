package test.oz.todoapp.Domain

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import test.oz.todoapp.Data.UserModel

interface UserService {

    @GET("users/{id}")
    fun getUserId(
        @Path("id") userId : Int
    ) : Call<UserModel>
}