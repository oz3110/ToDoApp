package test.oz.todoapp.Domain

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST
import test.oz.todoapp.Data.UserModel

interface IUserLoginRequest {
    @POST( "api/sessions/" )
    fun getUserId(
        @Body body: HashMap<String, String>
    ) : Observable<Response<UserModel>>
}