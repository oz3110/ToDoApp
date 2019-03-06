package test.oz.todoapp

abstract class LoginModelObserver {
    abstract fun observe( user_Id : String, user_Pass : String ) : Boolean
}