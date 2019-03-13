package test.oz.todoapp.Data

data class UserModel(
    var id : Int,
    var name : String,
    var email : String,
    var password : String,
    var remember_token : String,
    var created_at : String,
    var updated_at : String
)