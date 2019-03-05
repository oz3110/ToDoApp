package test.oz.todoapp

abstract class LoginControllerMediator {
    abstract fun login( user_id : String, user_pass : String ) : Boolean
}