package test.oz.todoapp

class LoginController( loginModelObserver : LoginModelObserver ) : LoginControllerMediator(){
    val m_LoginDB = loginModelObserver

    override fun login( user_id : String, user_pass : String ) : Boolean{
        return m_LoginDB.observe(user_id, user_pass)
    }
}