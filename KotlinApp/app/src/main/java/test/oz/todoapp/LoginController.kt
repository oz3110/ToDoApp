package test.oz.todoapp

class LoginController : LoginControllerMediator(){
    override fun login( user_id : String, user_pass : String ) : Boolean{
        // modelにデータを送り、ＤＢと通信する

        return true
    }
}