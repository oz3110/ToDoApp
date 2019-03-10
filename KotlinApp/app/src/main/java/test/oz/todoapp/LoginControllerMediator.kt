package test.oz.todoapp

abstract class LoginControllerMediator {
    abstract fun login( userId : String, userPass : String ) : Boolean
}