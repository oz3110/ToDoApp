package test.oz.todoapp

abstract class LoginModelObserver {
    abstract fun observe( userId : String, userPass : String ) : Boolean
}