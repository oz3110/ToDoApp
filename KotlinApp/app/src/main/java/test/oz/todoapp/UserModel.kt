package test.oz.todoapp

data class UserModel(
    var uniqueID : Int,
    var userID : String,
    var userPass : String,
    var adminFlg : Boolean
)