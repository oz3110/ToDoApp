package test.oz.todoapp

class LoginController( loginModelObserver : LoginModelObserver ) : LoginControllerMediator(){
    val LoginDB = loginModelObserver

    override fun login( userId : String, userPass : String ) : Boolean{
        return LoginDB.observe(userId, userPass)
    }
}