package test.oz.todoapp

class LoginModel : LoginModelObserver(){
    override fun observe(user_Id: String, user_Pass: String) : Boolean{
        return true
    }
}